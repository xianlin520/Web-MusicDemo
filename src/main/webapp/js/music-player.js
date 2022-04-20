new Vue({
    el: "#app",
    mounted() {
        this.getVideo();
    },
    methods: {
        getVideo() {
            document.querySelector('.SongPlayer').volume = 0.1;
        },
        SearchSong() {
            var _this = this;
            axios.get("http://ovooa.com/API/wydg/api.php?sc=50&msg=" + this.InputName)
                .then(response => {
                    this.Songs = response.data.Msg;
                    // console.log(this.Songs);
                    _this.SongsList = this.Songs;
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
            var song_id = (song / 10).toFixed(1);
            p = parseInt(song_id.split(".")[0]);
            n = parseInt(song_id.split(".")[1]);
            // console.log(song_id.split("."));
            axios.get("http://ovooa.com/API/wydg/api.php?sc=51&msg=" + this.InputName + "&p=" + (p + 1) + "&n=" + (n + 1))
                .then(response => {
                    // console.log(response.data);
                    _this.SongData = response.data.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
    },
    data() {
        return {
            InputName: "许嵩",
            SongsList: [
                "清明雨上—许嵩",
                "有何不可—许嵩",
                "素颜—许嵩,何曼婷",
                "玫瑰花的葬礼—许嵩",
                "雅俗共赏—许嵩",
                "多余的解释—许嵩",
                "庐州月—许嵩",
                "幻听—许嵩",
                "断桥残雪—许嵩",
                "天龙八部之宿敌—许嵩"
            ],
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
            }
        }
    }
});