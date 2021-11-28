<template xmlns:el-form-item="http://www.w3.org/1999/html">
  <div style="padding: 10px">
<!--    功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

    <el-table :data="tableData" border style="width: 100%" stripe>
      <el-table-column prop="id" label="ID"  sortable/>
      <el-table-column prop="username" label="姓名"  />
      <el-table-column prop="nickname" label="昵称" />
      <el-table-column prop="age" label="年龄"/>
      <el-table-column prop="sex" label="性别"  />
      <el-table-column prop="address" label="地址" />

      <el-table-column fixed="right" label="操作">
        <template #default="scope">
          <el-button @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="Are you sure to delete this?">
            <template #reference>
              <el-button>删除</el-button>
            </template>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>
    <div class="demo-pagination-block">

      <el-pagination
          v-model:currentPage="currentPage2"
          :page-sizes="[5, 10, 20]"
          :page-size="10"
          layout="total ,sizes, prev, pager, next,jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    <!--    搜索区域-->
    <div>
      <el-input v-model="search" placeholder="输入关键字" style="width: 20%"/>
      <el-button type="primary" style="margin-left: 5px">搜索</el-button>
    </div>


      <el-dialog
          v-model="dialogVisible"
          title="Tips"
          width="30%"
      >
        <el-form model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.username" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickname" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>

          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.add" style="width: 80%;"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button
        >
      </span>
        </template>
      </el-dialog>


  </div>

  </div>
</template>

<script>



import request from "@/utils/request";


export default {
  name: 'Home',
  components: {

  },
  data(){
    return {
      form:{},
      dialogVisible:false,
      search:'',
      currentPage2:1,
      total:10,
      tableData:[{
        date: '2016-05-03',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
      },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },]
    }
  },
  methods:{
    save(){
      request.post("/user",this.form).then(res =>{
        console.log(res)
      })
    },
    add(){
      this.dialogVisible=true
      this.form={}
    },
    handleEdit(){},
    handleSizeChange(){},
    currentPage2(){},
    handleCurrentChange(){}

  }

}
</script>
