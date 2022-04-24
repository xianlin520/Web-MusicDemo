new Vue({
    el: "#app",
    mounted() {
        this.getVideo();
        this.obtainText();
    },
    methods: {
        getVideo() {
            document.querySelector('.SongPlayer').volume = 0.1;
        },
        SearchSong() {
            var _this = this;
            axios.get("http://ovooa.com/API/wydg/api.php?sc=10&msg=" + this.InputName)
                .then(response => {
                    var Songs = response.data.data;
                    // console.log(Songs);
                    _this.SongDataList = Songs;
                    this.$message({
                        message: '搜索成功',
                        type: 'success'
                    });
                })
                .catch(error => {
                    console.log(error);
                });
        },
        player(song) {
            var _this = this;
            // console.log(song);
            // var song_id = song/10;
            // song除10保留1位小数
            // var song_id = (song / 10).toFixed(1);
            // p = parseInt(song_id.split(".")[0]);
            // n = parseInt(song_id.split(".")[1]);
            // console.log(song_id.split("."));
            // axios.get("http://ovooa.com/API/wydg/api.php?sc=51&msg=" + this.InputName + "&p=" + (p + 1) + "&n=" + (n + 1))
            axios.get("http://ovooa.com/API/wydg/api.php?msg=" + this.InputName + "&n=" + (song + 1))
                .then(response => {
                    // console.log(response.data);
                    _this.SongData = response.data.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        obtainText() {
            var _this = this;
            axios.get("http://ovooa.com/API/wryl/api.php")
                .then(response => {
                    // console.log(response.data);
                    _this.showText = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    data() {
        return {
            InputName: "",
            SongData: {
                "Id": 167882,
                "Music": "清明雨上",
                "Cover": "http://p3.music.126.net/KyBR4ZDYFlzQJE_uyvfjpA==/109951166118671647.jpg",
                "Singer_Array": [
                    "许嵩"
                ],
                "Singer": "许嵩",
                "Url": "http://music.163.com/song/media/outer/url?id=167882",
                "Music_Url": "https://music.163.com/#/song?id=167882"
            },
            SongDataList: [{
                "song": "清明雨上",
                "singer": ["许嵩"],
                "singers": "许嵩"
            },
                {
                    "song": "有何不可",
                    "singer": ["许嵩"],
                    "singers": "许嵩"
                }],
            showText: "",
        }
    }
});