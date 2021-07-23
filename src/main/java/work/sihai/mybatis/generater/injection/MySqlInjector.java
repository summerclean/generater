package work.sihai.mybatis.generater.injection;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import work.sihai.mybatis.generater.injection.method.DeleteByName;

import java.util.List;

public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        //保留原有方法
        List<AbstractMethod> list=super.getMethodList(mapperClass);
        //新增方法
        list.add(new DeleteByName());
        return list;
    }

}
