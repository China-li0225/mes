package com.mes.demo.mapper;

import com.mes.common.annotation.DataColumn;
import com.mes.common.annotation.DataPermission;
import com.mes.common.core.mapper.BaseMapperPlus;
import com.mes.demo.domain.TestTree;
import com.mes.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author Lion Li
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTreeMapper, TestTree, TestTreeVo> {

}
