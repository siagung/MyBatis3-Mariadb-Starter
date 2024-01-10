/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mkl.mybatisrep;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import com.mkl.mybatisrep.domain.Product;
import com.mkl.mybatisrep.services.ProductService;
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
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isNull;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Admin
 */
public class Mybatisrep {

    private static Logger logger = LoggerFactory.getLogger(Mybatisrep.class);
    private static final String APP_ID = "mybatisrep";
    private static final String APP_DIR = System.getProperty("user.dir").concat(File.separator).concat("bin");

    private ProductService productservice = null;
    //private Mybatisrep myrep;

    public static String appFolderPath(String currentUsersHomeDir) {
        return currentUsersHomeDir;
    }

    public static String appConfigPath() {
        String appConfig = appFolderPath(getAPP_DIR()) + File.separator + "config.properties";
        return appConfig;
    }

    private Product getListProduct(Integer id, String cbarang, String vnama_barang, boolean banalisa, boolean breduct, Integer btipe, boolean baktif, int no) {
        Product prd = new Product();
        prd.setNourut(no);
        prd.setId(id);
        prd.setCbarang(cbarang);
        prd.setVnama_barang(vnama_barang);
        prd.setBanalisa(banalisa);
        prd.setBreduct(breduct);
        prd.setBtipe(btipe);
        prd.setBaktif(baktif);
        return prd;
    }

    public static void main(String[] args) {
        Mybatisrep myrep = new Mybatisrep();
        myrep.productservice = new ProductService();
        EventList<Product> list = new BasicEventList<>();
        try {
            list.getReadWriteLock().writeLock().lock();
            int rec = 0;
            List productAll = myrep.productservice.findAll();
            for (Iterator it = productAll.iterator(); it.hasNext();) {
                rec = rec + 1;
                Product prd = (Product) it.next();
                logger.info("produk : " + prd.getCbarang());
                list.add(myrep.getListProduct(prd.getId(), prd.getCbarang(), prd.getVnama_barang(), prd.isBanalisa(), prd.isBreduct(), prd.isBtipe(), prd.isBaktif(), rec));
            }
        } finally {
            list.getReadWriteLock().writeLock().unlock();
        }
       logger.info("---------------------------------------");       
        Product prdIns = new Product();
        prdIns.setCbarang("010");
        prdIns.setVnama_barang("Produk 010");
        if (myrep.productservice.createProduct(prdIns) == 1) {
            logger.info("produk - " + prdIns.getVnama_barang() + " tersimpan.");
        }else{
        logger.error("produk - " + prdIns.getVnama_barang() + " gagal simpan!");
        }
        
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
           for (Iterator it = rows.iterator(); it.hasNext();) {
                //rec = rec + 1;
                PersonRecord prs = (PersonRecord) it.next();
                logger.info("person : " + prs.getFirstName() +"-"+prs.getBirthDate());
                //list.add(myrep.getListProduct(prd.getId(), prd.getCbarang(), prd.getVnama_barang(), prd.isBanalisa(), prd.isBreduct(), prd.isBtipe(), prd.isBaktif(), rec));
            }
           }
    }

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * @return the APP_ID
     */
    public static String getAPP_ID() {
        return APP_ID;
    }

    /**
     * @return the APP_DIR
     */
    public static String getAPP_DIR() {
        return APP_DIR;
    }
}
