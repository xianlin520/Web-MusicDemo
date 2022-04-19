import org.apache.ibatis.session.SqlSession;
import xyz.xianlin.mapper.UserDataMapper;
import xyz.xianlin.pojo.UserData;
import xyz.xianlin.tool.SQLSingleton;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = SQLSingleton.getSqlSessionFactory().openSession();
        UserDataMapper mapper = sqlSession.getMapper(UserDataMapper.class);
        String username = "\uD835\uDCEB\uD835\uDCF8\uD835\uDCFD、";
        String user = "\uD835\uDCEB";
        String name = "𝓫𝓸𝓽、";
//        byte[] bytes = username.getBytes(StandardCharsets.UTF_8);
//        String s = new String(bytes, StandardCharsets.UTF_8);
        mapper.insert(new UserData("213123", "羡林i","132"));
        // 对username进行utf8mb4编码
//        byte[] bytes = username.getBytes(StandardCharsets.UTF_16);
//        String s = new String(bytes, StandardCharsets.UTF_16);
//        System.out.println(s);
//        mapper.insert(new UserData("213123", s, "132"));
        /*// 对字符串进行base64编码
        String s = new String(Base64.encodeBase64(username.getBytes()));
        UserData userData = mapper.selectByUserQQ("213123");
        String userName = userData.getUserName();
        // 对userName进行base64解码
        byte[] bytes = Base64.decodeBase64(userName.getBytes());
        String s1 = new String(bytes, StandardCharsets.UTF_8);*/
//        System.out.println(s1);
        sqlSession.commit();
        sqlSession.close();
    }
    
    @org.junit.jupiter.api.Test
    public void Main() {
//        System.out.println("\uD835\uDCEB\uD835\uDCF8\uD835\uDCFD、");
        System.out.println('t');
    }
}
