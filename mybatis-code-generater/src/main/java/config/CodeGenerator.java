package config;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IKeyWordsHandler;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.baomidou.mybatisplus.generator.type.ITypeConvertHandler;
import com.baomidou.mybatisplus.generator.type.TypeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 17:53
 */
public class CodeGenerator {

    private static final String DB_NAME = "zcct-user";
    private static final String MODEL_NAME = "com.zcct.security.demo";
   // private static final String[] TABLE_NAME = {"sys_dept","sys_post","sys_role","sys_role_dept","sys_user","sys_user_post","sys_user_role"};

    private static final String[] TABLE_NAME = {"sys_menu"};

    private static final String PARENT_PATH = "E:\\study_spance\\zcctframe\\spring-security-demo\\src\\main\\java\\";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zclvct";


    public static void main(String[] args) {
        DataSourceConfig.Builder bu = new DataSourceConfig.Builder(URL,USERNAME,PASSWORD);
        bu.typeConvertHandler(new ITypeConvertHandler() {
            @Override
            public @org.jetbrains.annotations.NotNull IColumnType convert(GlobalConfig globalConfig, TypeRegistry typeRegistry, TableField.MetaInfo metaInfo) {
                IColumnType columnType = typeRegistry.getColumnType(metaInfo);
                System.out.println("转换类型：" + columnType.getType());
                //tinyint转换成Boolean
                if (columnType.equals(DbColumnType.BYTE)) {
                    return DbColumnType.INTEGER;
                }
                //将数据库中datetime转换成date
                if (columnType.equals(DbColumnType.LOCAL_DATE_TIME)) {
                    return DbColumnType.TIMESTAMP;
                }
                return columnType;

            }
        });
        FastAutoGenerator.create(bu)
                .globalConfig(builder -> {
                    builder
                            // （重要）配置输出的文件夹，springboot项目可以使用如下方式
                            .outputDir(PARENT_PATH)
                            // （重要）时间类型，看你喜欢用sql包中的Date、util包中的Date还是更新的LocalDateTime
                            .dateType(DateType.TIME_PACK)
                            // 配置生成文件中的author
                            .author("zcct")
                            .enableSwagger()
                            // 注释日期的格式
                            .commentDate("yyyy-MM-dd")
                            .build();

                })
                .packageConfig(builder -> {
                    builder.parent(MODEL_NAME)// （重要）配置公共的父包名，建议配置
                            // 配置entity包名，默认entity，可以不配置
                            .entity("domain")
                            // 配置service包名，默认service，可以不配置，下面的配置也是
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("repository")
                            .controller("rest")
                            .build();

                })
                .strategyConfig(builder -> {
                    builder.enableSkipView().addInclude(TABLE_NAME).addTablePrefix("sys_").addFieldPrefix("is_");
                    builder.entityBuilder()
                            .enableFileOverride()
                            .enableLombok()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .logicDeleteColumnName("is_deleted")
                            .logicDeletePropertyName("deleted")
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("create_by", FieldFill.INSERT))
                            .addTableFills(new Column("update_by", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .idType(IdType.AUTO)
                            .build();
                    builder.controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()
                            .formatFileName("%sController")
                            .build();
                    builder.serviceBuilder()
                            .enableFileOverride()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .build();

                    builder.mapperBuilder()
                            .enableFileOverride()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sRepository")
                            .build();

                })
                .execute();

    }

}
