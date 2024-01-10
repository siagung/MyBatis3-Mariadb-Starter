
import com.mkl.mybatisrep.datasource.DataSourceFactory;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.addressId;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.birthDate;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.employed;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.firstName;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.id;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.lastName;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.occupation;
import static com.mkl.mybatisrep.test.people.PersonDynamicSqlSupport.person;
import com.mkl.mybatisrep.test.people.PersonMapper;
import com.mkl.mybatisrep.test.people.PersonRecord;
import com.mkl.mybatisrep.utils.MyBatisSqlSessionFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static org.mybatis.dynamic.sql.SqlBuilder.deleteFrom;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isNull;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class testc {
    @Test
    void testGeneralSelect() {
    try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        SelectStatementProvider selectStatement = select(id.as("A_ID"), firstName, lastName, birthDate, employed,
            occupation, addressId)
        .from(person)
        .where(id, isEqualTo(1))
        .or(occupation, isNull())
        .build()
        .render(RenderingStrategies.MYBATIS3);

        List<PersonRecord> rows = mapper.selectMany(selectStatement);
        assertThat(rows).toString();
    }
}

@Test
void testGeneralDelete() {
    try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        DeleteStatementProvider deleteStatement = deleteFrom(person)
        .where(occupation, isNull())
        .build()
        .render(RenderingStrategies.MYBATIS3);

        int rows = mapper.delete(deleteStatement);
        //assertThat(rows).isEqualTo(2);
    }
}

    private Object assertThat(List<PersonRecord> rows) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
