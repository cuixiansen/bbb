window.onload = function(){
    
    getRem(1920,24)
};
window.onresize = function(){
    getRem(1920,24)
};
function getRem(pwidth,prem){
    var html = document.getElementsByTagName("html")[0]; //获取html标签
    var oWidth = document.body.clientWidth || document.documentElement.clientWidth;
    //获得当前设备的宽度
    html.style.fontSize = oWidth/pwidth*prem + "px"; //将当前设备计算出来的字号加进html中
}