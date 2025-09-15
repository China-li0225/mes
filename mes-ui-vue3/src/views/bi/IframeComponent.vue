<template>
  <div class="iframe-container">
    <iframe :id="iframeId()" ref="iframe" :src="src" :style="iframeStyle"></iframe>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted, computed } from "vue";

export default defineComponent({
  name: "IframeComponent",
  props: {
    src: {
      type: String,
      required: true,
    },
    fullscreen: {
      type: Boolean,
      default: false,
    },
  },
  setup(props) {
    const iframe = ref<HTMLIFrameElement | null>(null);

    const iframeStyle = computed(() => ({
      width: props.fullscreen ? "100vw" : "600px",
      height: props.fullscreen ? "100vh" : "400px",
      border: "none",
    }));

    onMounted(() => {
      if (iframe.value) {
        iframe.value.addEventListener("load", () => {
          console.log("Iframe loaded");
        });
      }
    });

    const iframeId = () => {
      return "headwater" + Math.random()*100000000
    };

    return {
      iframe,
      iframeStyle,
      iframeId
    };
  },
});
</script>

<style scoped>
.iframe-container {
  position: relative;
  overflow: hidden;
}
</style>
