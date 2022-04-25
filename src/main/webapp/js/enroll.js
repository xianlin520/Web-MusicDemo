new Vue({
    el: '#app',
    mounted() {
        // this.open();
    },
    methods: {
        obtain() {
            var _this = this;
            axios.get('http://ovooa.com/API/qqxx/?QQ=' + this.userForm.userQQ).then(function (response) {
                console.log(response);
                if (response.data.code == 1) {
                    // _this.$message.success("获取成功"+'    '+"昵称:"+response.data.data.name);
                    _this.userForm.userName = response.data.data.name;
                    _this.userForm.imgUrl = response.data.data.imgurl;
                } else {
                    _this.$message.error("此QQ号不存在");
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        // 定义一个方法, 返回布尔值
        checkByUserInfo() {
            var _this = this;
            // 检查UserInfo.name是否匹配中文,英文,数字,下划线,点,减号,空格,逗号
            var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9\.,\-\s]+$/;
            // 检查UserInfo.name是否匹配正则表达式red
            if (reg.test(_this.userForm.userName)) {

                // _this.$message.error("昵称不能包含特殊字符");
                // return false;
                _this.checkUserName = true;
            } else {
                // return true;
                _this.checkUserName = false;
            }
        },
        submitForm(formName) {
            var _this = this;
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    // _this.obtain();
                    _this.check();
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        check: function () {
            _this = this;
            axios.get('/users/' + this.userForm.userQQ).then(function (response) {
                console.log(response);
                if (response.data.code == 30011) {
                    _this.$message.error({
                        message: '此账号已被注册, 可直接登录; 如果忘记密码, 请联系管理员找回密码',
                        duration: 5000,
                        showClose: true,
                    });
                    /*this.$notify({
                        title: '此QQ不可用',
                        message: '此账号已被注册, 可直接登录; 如果忘记密码, 请联系管理员找回密码, 谢谢',
                        type: 'warning'
                    });*/
                } else {
                    // alert('open');
                    // _this.open();
                    _this.dialogVisible = true;
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        open() {
            // this.dialogVisible = true;
            _this = this;
            this.userForm.userPassword = this.ruleForm.checkPass;
            this.checkByUserInfo();
            const loading = this.$loading({
                lock: true,
                text: '注册中...',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
            });
            setTimeout(() => {
                loading.close();
            }, 500);
            if (_this.checkUserName) {
                setTimeout(() => {
                    axios.put('/users', this.userForm).then(function (response) {
                        console.log(response);
                        if (response.data.code == 40071) {
                            _this.$message({
                                type: 'success',
                                message: '注册成功'
                            });
                        } else {
                            _this.$message.error("注册失败");
                        }

                        this.dialogVisible = false;
                    })
                }, 800);
            } else {
                setTimeout(() => {
                    this.$message.error('昵称不能包含特殊字符');
                }, 800);
            }
        }
    },


    data() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkPass');
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.pass) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        return {
            dialogVisible: false,
            checkUserName: false,
            userForm: {
                userQQ: '',
                userName: '佚名',
                userPassword: '',
                imgUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
            },
            /*formCheck: {
                userName: '',
            },*/
            ruleForm: {
                pass: '',
                checkPass: '',
            },
            rules: {
                pass: [
                    {validator: validatePass, trigger: 'blur'}
                ],
                checkPass: [
                    {validator: validatePass2, trigger: 'blur'}
                ],

            }
        };
    }
})