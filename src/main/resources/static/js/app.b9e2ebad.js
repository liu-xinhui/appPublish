(function(e){function t(t){for(var r,o,i=t[0],c=t[1],s=t[2],l=0,f=[];l<i.length;l++)o=i[l],Object.prototype.hasOwnProperty.call(u,o)&&u[o]&&f.push(u[o][0]),u[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);d&&d(t);while(f.length)f.shift()();return a.push.apply(a,s||[]),n()}function n(){for(var e,t=0;t<a.length;t++){for(var n=a[t],r=!0,o=1;o<n.length;o++){var i=n[o];0!==u[i]&&(r=!1)}r&&(a.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},o={app:0},u={app:0},a=[];function i(e){return c.p+"js/"+({}[e]||e)+"."+{"chunk-192dbb74":"16ce9065","chunk-29b4b007":"abc773f2","chunk-4991d251":"ee285d6a","chunk-66f23a77":"0203138c","chunk-7f28e875":"2d14c902"}[e]+".js"}function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={"chunk-192dbb74":1,"chunk-29b4b007":1,"chunk-4991d251":1,"chunk-66f23a77":1,"chunk-7f28e875":1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-192dbb74":"8dddd937","chunk-29b4b007":"6e4fb2aa","chunk-4991d251":"d43a285b","chunk-66f23a77":"999b311d","chunk-7f28e875":"febb86a2"}[e]+".css",u=c.p+r,a=document.getElementsByTagName("link"),i=0;i<a.length;i++){var s=a[i],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===r||l===u))return t()}var f=document.getElementsByTagName("style");for(i=0;i<f.length;i++){s=f[i],l=s.getAttribute("data-href");if(l===r||l===u)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var r=t&&t.target&&t.target.src||u,a=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");a.code="CSS_CHUNK_LOAD_FAILED",a.request=r,delete o[e],d.parentNode.removeChild(d),n(a)},d.href=u;var p=document.getElementsByTagName("head")[0];p.appendChild(d)})).then((function(){o[e]=0})));var r=u[e];if(0!==r)if(r)t.push(r[2]);else{var a=new Promise((function(t,n){r=u[e]=[t,n]}));t.push(r[2]=a);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,c.nc&&l.setAttribute("nonce",c.nc),l.src=i(e);var f=new Error;s=function(t){l.onerror=l.onload=null,clearTimeout(d);var n=u[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;f.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",f.name="ChunkLoadError",f.type=r,f.request=o,n[1](f)}u[e]=void 0}};var d=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(t)},c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var d=l;a.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"07a4":function(e,t){},"27dc":function(e,t,n){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("8bbf"),o=n.n(r),u=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},a=[],i=(n("5c0b"),n("2877")),c={},s=Object(i["a"])(c,u,a,!1,null,null,null),l=s.exports,f=(n("d3b7"),n("6389")),d=n.n(f);o.a.use(d.a);var p=[{path:"/",meta:{title:"Main中展示的组件"},component:function(){return n.e("chunk-29b4b007").then(n.bind(null,"6b61"))},children:[{path:"/",meta:{title:"首页"},component:function(){return n.e("chunk-66f23a77").then(n.bind(null,"5691"))}},{path:"apps/:id",meta:{title:"应用动态"},component:function(){return n.e("chunk-7f28e875").then(n.bind(null,"126c"))}}]},{path:"/login",meta:{title:"登录"},component:function(){return n.e("chunk-192dbb74").then(n.bind(null,"da0d"))}},{path:"/preview",meta:{title:"预览"},component:function(){return n.e("chunk-4991d251").then(n.bind(null,"5bbe"))}}],h=new d.a({mode:"history",routes:p});h.beforeEach((function(e,t,n){n()}));var g=h,b=n("07a4"),m=n.n(b),v=n("5f72"),y=n.n(v);o.a.use(y.a,{size:"medium"});var k=n("bc3a"),w=n.n(k),O=n("af3d");w.a.defaults.timeout=4e4,w.a.defaults.baseURL=window.config.serverUrl,w.a.interceptors.request.use((function(e){return e.headers["Authorization"]=O["a"].getToken(),e}),(function(e){return Promise.reject(e)})),w.a.interceptors.response.use((function(e){return e}),(function(e){return console.log("-------------接口请求错误信息start-------------"),console.log(e),e.response?(console.log(e.response.data,e.response.status,e.response.headers),v["Notification"].error({title:"提示",message:e.response.data.message})):e.request?(console.log(e.request),v["Notification"].error({title:"提示",message:"连接服务器失败"})):(console.log("Error",e.message),v["Notification"].error({title:"提示",message:"请求服务器出错"})),console.log("-------------接口请求错误信息end-------------"),Promise.reject(e)}));var E=w.a,P=new o.a;Plugin.install=function(e){e.prototype.$bus=P,e.prototype.$http=E,e.prototype.$axios=E,e.config.errorHandler=function(e,t,n){console.error(e,t,n),v["Message"].error(e)}},o.a.use(Plugin);Plugin,n("f5df1"),n("27dc");var j=n("3a34"),x=n.n(j);o.a.use(new x.a),o.a.config.productionTip=!1,new o.a({router:g,store:m.a,render:function(e){return e(l)}}).$mount("#app")},"5c0b":function(e,t,n){"use strict";var r=n("9c0c"),o=n.n(r);o.a},"5f72":function(e,t){e.exports=ELEMENT},6389:function(e,t){e.exports=VueRouter},"8bbf":function(e,t){e.exports=Vue},"9c0c":function(e,t,n){},af3d:function(e,t,n){"use strict";n("c975");var r="hold_user_info",o=window.localStorage,u=null,a=1;t["a"]={login:function(e){u=e,o.setItem(r,JSON.stringify(e))},logout:function(){u=null,o.clear()},isLogin:function(){return!!this.getToken()},getUserInfo:function(){try{u||(u=JSON.parse(o.getItem(r)))}catch(e){console.log(e)}return u||{}},getToken:function(){return this.getUserInfo().token},getUsername:function(){return this.getUserInfo().userName},getUserId:function(){return this.getUserInfo().userID},hasAuth:function(e){return this.getUserId()===a||(this.getUserInfo().permissions||[]).indexOf(e)>-1}}}});
//# sourceMappingURL=app.b9e2ebad.js.map