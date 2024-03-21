<template>
  <div class="app-container">
    <el-table v-loading="loading" :data="purchaseOrderList" @selection-change="handleSelectionChange">
      <el-table-column label="id" align="center" prop="id" v-if="true"/>
      <el-table-column label="采购订单号" align="center" prop="purchaseNo" />
      <el-table-column label="采购物料类型" align="center" prop="purchaseType" />
      <el-table-column label="采购订单状态" align="center" prop="purchaseState" />
      <el-table-column label="发起部门" align="center" prop="startDept" />
      <el-table-column label="发起部门id" align="center" prop="startDeptId" />
    </el-table>
    <a>销售订单明细</a>
    <el-table v-loading="loading" :data="purchaseDetilsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="40" align="center" />
      <el-table-column label="id" align="center" prop="id" v-if="true"/>
      <el-table-column label="采购订单号" align="center" prop="purchaseNo" width="100" />
      <el-table-column label="物料id" align="center" prop="matId" />
      <el-table-column label="物料名称" align="center" prop="matName" />
      <el-table-column label="物料大类" align="center" prop="matType" />
      <el-table-column label="物料大类编码" align="center" prop="matTypeNo" width="120" />
      <el-table-column label="规格" align="center" prop="model" />
      <el-table-column label="颜色" align="center" prop="color" />
      <el-table-column label="重量" align="center" prop="weight" />
      <el-table-column label="长度" align="center" prop="lenth" />
      <el-table-column label="数量" align="center" prop="num" />
      <el-table-column label="单位" align="center" prop="unit" />
<!--      <el-table-column label="单位单价" align="center" prop="prices" />-->
<!--      <el-table-column label="不含税单价" align="center" prop="taxFreePrice" />-->
<!--      <el-table-column label="含税总价" align="center" prop="sumPricesTax" />-->
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['mes:purchaseDetils:edit']"
          >修改</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

<!--    &lt;!&ndash; 添加或修改采购订单明细对话框 &ndash;&gt;-->
<!--    <el-dialog :title="title" v-model="open" width="800px" append-to-body>-->
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="120px">-->
<!--        <el-form-item label="采购订单号" prop="purchaseNo">-->
<!--          <el-input v-model="form.purchaseNo" placeholder="请输入采购订单号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="物料id" prop="matId">-->
<!--          <el-input v-model="form.matId" placeholder="请输入物料id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="物料名称" prop="matName">-->
<!--          <el-input v-model="form.matName" placeholder="请输入物料名称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="物料大类编码" prop="matTypeNo">-->
<!--          <el-input v-model="form.matTypeNo" placeholder="请输入物料大类编码" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="规格" prop="model">-->
<!--          <el-input v-model="form.model" placeholder="请输入规格" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="颜色" prop="color">-->
<!--          <el-input v-model="form.color" placeholder="请输入颜色" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="重量" prop="weight">-->
<!--          <el-input v-model="form.weight" placeholder="请输入重量" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="长度" prop="lenth">-->
<!--          <el-input v-model="form.lenth" placeholder="请输入长度" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="数量" prop="num">-->
<!--          <el-input v-model="form.num" placeholder="请输入数量" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="单位" prop="unit">-->
<!--          <el-input v-model="form.unit" placeholder="请输入单位" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="单位单价" prop="prices">-->
<!--          <el-input v-model="form.prices" placeholder="请输入单位单价" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="不含税单价" prop="taxFreePrice">-->
<!--          <el-input v-model="form.taxFreePrice" placeholder="请输入不含税单价" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="含税总价" prop="sumPricesTax">-->
<!--          <el-input v-model="form.sumPricesTax" placeholder="请输入含税总价" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="备注" prop="remark">-->
<!--          <el-input v-model="form.remark" placeholder="请输入备注" />-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>-->
<!--        <el-button @click="cancel">取 消</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->
  </div>
</template>

<script>
import { listPurchaseDetils, getPurchaseDetils, delPurchaseDetils, addPurchaseDetils, updatePurchaseDetils } from "@/api/pr/purchase/purchaseDetils";

export default {
  name: "PurchaseDetils",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 采购订单明细表格数据
      purchaseDetilsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: undefined,
        purchaseNo: undefined,
        matId: undefined,
        matName: undefined,
        matType: undefined,
        matTypeNo: undefined,
        model: undefined,
        color: undefined,
        weight: undefined,
        lenth: undefined,
        num: undefined,
        unit: undefined,
        prices: undefined,
        taxFreePrice: undefined,
        sumPricesTax: undefined,
        remark: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "id不能为空", trigger: "blur" }
        ],
        purchaseNo: [
          { required: true, message: "采购订单号不能为空", trigger: "blur" }
        ],
        matId: [
          { required: true, message: "物料id不能为空", trigger: "blur" }
        ],
        matName: [
          { required: true, message: "物料名称不能为空", trigger: "blur" }
        ],
        matType: [
          { required: true, message: "物料大类不能为空", trigger: "change" }
        ],
        matTypeNo: [
          { required: true, message: "物料大类编码不能为空", trigger: "blur" }
        ],
        model: [
          { required: true, message: "规格不能为空", trigger: "blur" }
        ],
        color: [
          { required: true, message: "颜色不能为空", trigger: "blur" }
        ],
        weight: [
          { required: true, message: "重量不能为空", trigger: "blur" }
        ],
        lenth: [
          { required: true, message: "长度不能为空", trigger: "blur" }
        ],
        num: [
          { required: true, message: "数量不能为空", trigger: "blur" }
        ],
        unit: [
          { required: true, message: "单位不能为空", trigger: "blur" }
        ],
        prices: [
          { required: true, message: "单位单价不能为空", trigger: "blur" }
        ],
        taxFreePrice: [
          { required: true, message: "不含税单价不能为空", trigger: "blur" }
        ],
        sumPricesTax: [
          { required: true, message: "含税总价不能为空", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询采购订单明细列表 */
    getList() {
      this.loading = true;
      listPurchaseDetils(this.queryParams).then(response => {
        this.purchaseDetilsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        purchaseNo: undefined,
        matId: undefined,
        matName: undefined,
        matType: undefined,
        matTypeNo: undefined,
        model: undefined,
        color: undefined,
        weight: undefined,
        lenth: undefined,
        num: undefined,
        unit: undefined,
        prices: undefined,
        taxFreePrice: undefined,
        sumPricesTax: undefined,
        remark: undefined,
        createBy: undefined,
        createTime: undefined,
        updateBy: undefined,
        updateTime: undefined,
        delFlag: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加采购订单明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getPurchaseDetils(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改采购订单明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updatePurchaseDetils(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addPurchaseDetils(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除采购订单明细编号为"' + ids + '"的数据项？').then(() => {
        this.loading = true;
        return delPurchaseDetils(ids);
      }).then(() => {
        this.loading = false;
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      }).finally(() => {
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('mes/purchaseDetils/export', {
        ...this.queryParams
      }, `purchaseDetils_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
