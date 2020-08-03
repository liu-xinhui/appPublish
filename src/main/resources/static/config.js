/*全局配置文件，url类型的必须以"/"结尾*/
var vueEnv = {
  //当前激活的环境
  active: "test",
  //开发环境
  dev: {
    serverUrl: "http://127.0.0.1:8060/api/",
  },
  test: {
    serverUrl: "http://118.25.44.86:8556/api/",
  },
  prod: {
    serverUrl: "/",
  },
};

switch (vueEnv.active) {
  case "dev":
    window.config = vueEnv.dev;
    break;
  case "test":
    window.config = vueEnv.test;
    break;
  default:
    window.config = vueEnv.prod;
    break;
}