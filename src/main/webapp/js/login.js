new Vue({
    el: '#app',
    mounted() {
    },
    methods: {
        onSubmit() {
            _this = this;
            axios.post("/users", this.form).then(function (response) {
                if (response.data.code == 20051) {
                    // alert("登录成功");
                    _this.$message.success("登录成功");
                } else {
                    _this.$message.error("登录失败");
                }
            }).catch(function (error) {
                console.log(error);
            });
            /*axios({
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
            });*/
        },
    },
    data() {
        return {
            form: {
                userQQ: '',
                userPassword: ''
            },
            loginType: false,
        }
    }
})