<template>
  <div class="parent-container">
    <h1>父组件</h1>
    <button @click="sendMessage">向Iframe发送消息</button>
    <button @click="toggleFullscreen">切换全屏</button>
    <IframeComponent ref="iframeComponent" :src="iframeSrc" :fullscreen="isFullscreen"/>
  </div>
</template>

<script>
import {ref} from "vue";
import IframeComponent from "@/views/bi/IframeComponent.vue";

export default {
  name: "ParentComponent",
  components: {IframeComponent},
  setup() {
    const iframeComponent = ref(null);
    const iframeSrc = "http://127.0.0.1/webroot/decision/login/cross/domain?fine_username=lixing&fine_password=lixing&validity=-2&callback=finereport";
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
}
</script>

<style scoped lang="scss">

</style>
