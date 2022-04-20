new Vue({
    el: '#app',
    mounted() {
    },
    methods: {
        obtain() {
            _this = this;
            axios.get('http://ovooa.com/API/qqxx/?QQ=' + this.form.QQ).then(function (response) {
                console.log(response);
                if (response.data.code == 1) {
                    _this.$message.success("获取成功");
                    _this.UserInfo.name = response.data.data.name;
                    _this.UserInfo.imgurl = response.data.data.imgurl;
                } else {
                    _this.$message.error("账号不存在");
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        onSubmit() {
            _this = this;
            axios({
                method: "post",
                url: "/login?userQQ=" + this.form.QQ + "&userPassword=" + this.form.password,
                data: this.form
            }).then(function (response) {
                if (response.data == 200) {
                    // alert("登录成功");
                    _this.$message.success("登录成功");
                } else {
                    _this.$message.error("登录失败");
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
    },
    data() {
        return {
            UserInfo: {
                imgurl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
                name: 'Test',
            },
            form: {
                QQ: '',
                password: '',
                type: false
            }
        }
    }
})