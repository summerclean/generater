package work.sihai.mybatis.generater.injection.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class DeleteByName extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "<script>\nDELETE FROM %s WHERE %s=#{%s}\n</script>";
        sql = String.format(sql, tableInfo.getTableName(), "name","name");
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, "deleteByName", sqlSource);
    }
}
