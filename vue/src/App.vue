<template>
  <div>
<!--    头部-->
    <Header />
    <div style="display: flex">
<!--主体-->

<!--      侧边栏-->
      <Aside />
      <router-view style="flex: 1"/>
    </div>
  </div>


</template>

<style>

</style>
<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside";

export default {
  name:"Layout",
  components:{
    Header,
    Aside
  }
}

</script>