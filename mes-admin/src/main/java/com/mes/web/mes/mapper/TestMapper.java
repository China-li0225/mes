package com.mes.web.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.common.core.domain.model.LoginUser;
import com.mes.web.mes.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: TestMapper <br/>
 * Description: <br/>
 * date: 2024/3/11 下午 1:09<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Mapper
public interface TestMapper  extends BaseMapper<Test> {
    Integer insertTest(@Param("test") Test test,@Param("user") LoginUser user);
}
