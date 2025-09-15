<template>
  <div class="parent-container">
    <h1>父组件</h1>
    <button @click="sendMessage">向Iframe发送消息</button>
    <button @click="toggleFullscreen">切换全屏</button>
    <IframeComponent ref="iframeComponent" :src="this.url" :fullscreen="isFullscreen"/>
  </div>
</template>

<script>
import {getFineAuthToken, getLoginUrl} from "@/api/bi/finereport";
import {nextTick, ref} from "vue";
import IframeComponent from "@/views/bi/IframeComponent.vue";

export default {
  name: "ParentComponent",
  setup() {
    const iframeComponent = ref(null);
    const iframeSrc = "https://example.com";
    const isFullscreen = ref(false);

    const sendMessage = () => {
      const iframeWindow = iframeComponent.value.$refs.iframe.contentWindow;
      if (iframeWindow) {
        iframeWindow.postMessage("来自父组件的问候", "*");
      }
    };

    const toggleFullscreen = () => {
      isFullscreen.value = !isFullscreen.value;
    };

    return {
      iframeComponent,
      iframeSrc,
      isFullscreen,
      sendMessage,
      toggleFullscreen,
    };
  },
  data(){
    return{
      fineAuthToken: '',
      name: 'lixing',
      ifnameId: '',
      url: '',
    }
  },
  created() {
    this.getFineAuthToken()
    this.getLoginUrl()
  },
  components: {
    IframeComponent
  },
  methods: {
    getLoginUrl(){
      getLoginUrl(name).then(res=>{
        this.url = res.data;
      })
    },
    getFineAuthToken(){
      getFineAuthToken().then(res =>{
        this.fineAuthToken = res.msg;
        // this.url = 'http://127.0.0.1/webroot/decision/v5/design/report/cb401e9554a143ea8b7a7bd135cfdfe9/view?fine_auth_token=' + this.fineAuthToken;
        console.log('url',this.url);
      })
    },
    getifnameId(){
      this.ifnameId = 'fine' + Math.random()*10000000000
      console.log('重新生成ifnameid',this.ifnameId)
      return this.ifnameId
    },
  },
}


const onLoad = () => {
  const query = imagrUrlString.value;
  const iframeWindow = window.frames[0]; // 获取iframe的window对象
  nextTick(() => {
    iframeWindow.postMessage({
      type: 'preview',
      data: query
    }, '*');
  });
}
</script>

<style scoped lang="scss">

</style>
