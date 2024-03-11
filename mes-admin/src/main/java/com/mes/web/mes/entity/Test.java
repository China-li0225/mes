package com.mes.web.mes.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: Test <br/>
 * Description: <br/>
 * date: 2024/3/11 下午 1:04<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("test")
public class Test extends BaseEntity {
    private String a;
    private String b;
}
