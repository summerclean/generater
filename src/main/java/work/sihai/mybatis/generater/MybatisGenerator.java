package work.sihai.mybatis.generater;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.SimpleAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

/**
 * @author yangjiahao
 */
public class MybatisGenerator {

    private static final String URL = "jdbc:mysql://localhost:13306/mageline_promotion_dev?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USER_NAME = "mgl_dev";
    private static final String PASSWORD = "vpW6cElr1gZMMEp2";

    private static final String PROJECT_PATH = "C:\\Users\\hu_19\\learn\\gen";

    private static final String AUTHOR = "karl";
    private static final String COMMENT_DATE_PATTERN = "yyyy-MM-dd";

    private static final String PARENT_NAME = "marketing";
    private static final String MODULE_NAME = "promotion";
    private static final String CONTROLLER_NAME = "controller";
    private static final String SERVICE_NAME = "service";
    private static final String SERVICE_IMPL_NAME = "service.impl";
    private static final String MAPPER_NAME = "mapper";
    private static final String XML_NAME = "mapper.xml";
    private static final String ENTITY_NAME = "entity";

    private static final String CONTROLLER_TEMPLATE = "/templates/controller.ftl";
    private static final String SERVICE_TEMPLATE = "/templates/service.ftl";
    private static final String SERVICE_IMPL_TEMPLATE = "/templates/serviceImpl.ftl";
    private static final String MAPPER_TEMPLATE = "/templates/mapper.ftl";
    private static final String MAPPER_XML_TEMPLATE = "/templates/mapper.ftl";
    private static final String ENTITY_TEMPLATE = "/templates/entity.ftl";

    private static final String TABLE_LIKE = "";
    private static final String TABLE_NOT_LIKE = "";
    private static final String CONTROLLER_SUPER_CLASS = "";
    private static final String SERVICE_SUPER_CLASS = "";
    private static final String SERVICE_IMPL_SUPER_CLASS = "";
    private static final String MAPPER_SUPER_CLASS = "";
    private static final String ENTITY_SUPER_CLASS = "";

    private static final String FREEMARKER_TEMPLATE_PATH = "/templates";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        new SimpleAutoGenerator() {

            //数据库配置
            @Override
            public IConfigBuilder<DataSourceConfig> dataSourceConfigBuilder() {
                return getDataSourceConfigBuilder();
            }
            //全局配置
            @Override
            public IConfigBuilder<GlobalConfig> globalConfigBuilder() {
                return getGlobalBuilder();
            }
            //包配置
            @Override
            public IConfigBuilder<PackageConfig> packageConfigBuilder() {
                return getPackageBuilder();
            }
            //模板配置
            @Override
            public IConfigBuilder<TemplateConfig> templateConfigBuilder() {
                return getTemplateBuilder();
            }
            //策略配置
            @Override
            public IConfigBuilder<StrategyConfig> strategyConfigBuilder() {
                return getStrategyBuilder();
            }

            //注入配置
            @Override
            public IConfigBuilder<InjectionConfig> injectionConfigBuilder() {
                return getInjectBuilder();
            }

            //引擎配置
            @Override
            public AbstractTemplateEngine templateEngine() {
                return getTemplateEngine();
            }
        }.execute();

    }

    private static AbstractTemplateEngine getTemplateEngine() {
        FreemarkerTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        templateEngine.templateFilePath(FREEMARKER_TEMPLATE_PATH);
        return templateEngine;
    }


    private static IConfigBuilder<InjectionConfig> getInjectBuilder() {
        InjectionConfig.Builder builder = new InjectionConfig.Builder();
        builder.beforeOutputFile((tableInfo,map)->{});
        return builder;
    }

    private static IConfigBuilder<StrategyConfig> getStrategyBuilder() {
        StrategyConfig.Builder builder = GeneratorBuilder.strategyConfigBuilder();
        builder
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .likeTable(new LikeTable(TABLE_LIKE))
                .notLikeTable(new LikeTable(TABLE_NOT_LIKE))
                .addTablePrefix()
                .addFieldPrefix()
                .addInclude()
                .addExclude();
        builder.controllerBuilder()
                .superClass(CONTROLLER_SUPER_CLASS)
//                .formatFileName()
//                .convertFileName()
                .enableHyphenStyle()
                .enableRestStyle();
        builder.serviceBuilder()
                .superServiceImplClass(SERVICE_IMPL_SUPER_CLASS)
                .superServiceClass(SERVICE_SUPER_CLASS)
//                .convertServiceFileName()
//                .convertServiceImplFileName()
//                .formatServiceFileName()
//                .formatServiceImplFileName()
        ;
        builder.mapperBuilder()
                .superClass(MAPPER_SUPER_CLASS)
//                .cache()
//                .convertMapperFileName()
//                .convertXmlFileName()
                .enableBaseColumnList()
                .enableBaseResultMap()
//                .formatXmlFileName()
//                .formatMapperFileName()
               ;
        builder.entityBuilder()
                .addIgnoreColumns()
//                .convertFileName()
                .superClass(ENTITY_SUPER_CLASS)
                .addSuperEntityColumns("deleted","version","create_time","create_user_id","create_user_name","update_time","update_user_id","update_User_name")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("UpdateTime",FieldFill.INSERT_UPDATE))
                .columnNaming(NamingStrategy.underline_to_camel)
                .enableActiveRecord()
                .enableChainModel()
                .enableColumnConstant()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableSerialVersionUID()
                .enableTableFieldAnnotation()
                .idType(IdType.AUTO)
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleted")
//                .nameConvert()
                .naming(NamingStrategy.underline_to_camel)
                .versionColumnName("version")
                .versionPropertyName("version");
        return builder;
    }

    private static IConfigBuilder<TemplateConfig> getTemplateBuilder() {
        TemplateConfig.Builder builder = GeneratorBuilder.templateConfigBuilder();
        builder.controller(CONTROLLER_TEMPLATE)
                .service(SERVICE_TEMPLATE,SERVICE_IMPL_TEMPLATE)
                .mapper(MAPPER_TEMPLATE)
                .mapperXml(MAPPER_XML_TEMPLATE)
                .entity(ENTITY_TEMPLATE);
        return builder;
    }

    private static IConfigBuilder<PackageConfig> getPackageBuilder() {
        PackageConfig.Builder builder = GeneratorBuilder.packageConfigBuilder();
        builder.parent(PARENT_NAME)
                .moduleName(MODULE_NAME)
                .controller(CONTROLLER_NAME)
                .service(SERVICE_NAME)
                .serviceImpl(SERVICE_IMPL_NAME)
                .mapper(MAPPER_NAME)
                .xml(XML_NAME)
                .entity(ENTITY_NAME);
        return builder;
    }

    private static IConfigBuilder<GlobalConfig> getGlobalBuilder() {
        GlobalConfig.Builder builder = GeneratorBuilder.globalConfigBuilder();
        builder.fileOverride()
                .openDir(true)
                .enableSwagger()
                .outputDir(PROJECT_PATH)
                .author(AUTHOR)
                .dateType(DateType.TIME_PACK)
                .commentDate(COMMENT_DATE_PATTERN);
        return builder;
    }


    private static DataSourceConfig.Builder getDataSourceConfigBuilder(){
        DataSourceConfig.Builder builder = new DataSourceConfig.Builder(URL, USER_NAME, PASSWORD);
//        builder.schema();
//        builder.dbQuery();
//        builder.keyWordsHandler();
//        builder.typeConvert();
        return builder;
    }

}
