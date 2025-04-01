package common;

import com.cjoa.wms.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBatisConfigTest {

    @Test
    void getSqlSession() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        assertNotNull(sqlSession);
    }
}