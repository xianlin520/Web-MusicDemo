package xyz.xianlin.pojo;

public class UserData {
    private Integer id;
    private String userQQ;
    private String userName;
    private String userPassword;
    
    /**
     * 传入QQ,昵称,密码,创建用户
     * 如果Name非法, 则用"非法ID"代替
     * @param userQQ 用户QQ
     * @param userName 用户昵称
     * @param userPassword 用户密码
     */
    public UserData(String userQQ, String userName, String userPassword) {
        this.userQQ = userQQ;
//         匹配中文,英文,数字,下划线,点,减号,空格,逗号,
        if (userName.matches("^[\\u4E00-\\u9FA5A-Za-z0-9_\\.\\-\\s,]+$")) {
            this.userName = userName;
        }else{
//            this.userName = "";
            //对于非法字符, 用"非法ID"替换
            this.userName = "非法ID";
        }
//        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    /**
     * 判断用户名和对应的密码是否正确, 用于登录(/login)
     * @param userQQ 用户QQ
     * @param userPassword 用户密码
     */
    public UserData(String userQQ, String userPassword) {
        this.userQQ = userQQ;
        this.userPassword = userPassword;
    }
    
    public UserData() {
    }
    
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserQQ() {
        return userQQ;
    }
    
    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userQQ='" + userQQ + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
