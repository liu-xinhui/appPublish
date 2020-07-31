/*全局配置文件，url类型的必须以"/"结尾*/
var vueEnv = {
  //当前激活的环境
  active: "dev",
  //开发环境
  dev: {
    serverUrl: "http://127.0.0.1:8060/api/",
  },
  prod: {
    serverUrl: "http://127.0.0.1:8060/api/",
  },
};

switch (vueEnv.active) {
  case "dev":
    window.config = vueEnv.dev;
    break;
  default:
    window.config = vueEnv.prod;
    break;
}
