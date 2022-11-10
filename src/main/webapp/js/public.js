
// 获取单个参数，已解码中文
function getParam(key) {
    let reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    //如果地址栏中出现中文则进行编码
    let r = encodeURI(window.location.search).substr(1).match(reg);
    if (r != null) {
        //将中文编码的字符重新变成中文
        return decodeURI(unescape(r[2]));
    }
    return null;
}


// 获取上个页面传过来的url参数列表，中文未解码
function getParams() {
    let url = location.search; //获取url中"?"符后的字串
    let theRequest = {};
    if (url.indexOf("?") != -1) {
        let str = url.substr(1);
        let str2 = str.split("&");
        for (let i = 0; i < str2.length; i++) {
            theRequest[str2[i].split("=")[0]] = unescape(str2[i].split("=")[1]);
        }
    }
    return theRequest;
}

// 获取当前项目地址
function getProjectPath() {
    //获取当前网址，如： http://localhost:8080/myproj/view/my.jsp
    let curWwwPath = window.document.location.href;

    //获取主机地址之后的目录，如： myproj/view/my.jsp
    let pathName = window.document.location.pathname;
    let pos = curWwwPath.indexOf(pathName);

    //获取主机地址，如： http://localhost:8080
    let localhostPaht = curWwwPath.substring(0, pos);

    //获取带"/"的项目名，如：/myproj
    let projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

    //得到了 http://localhost:8080/myproj
    return localhostPaht + projectName;
}


function getGender(i) {
    return i==1?"男":"女";
}

// 获取状态
function getStatus(status) {
    switch (status) {
        case 1:return "试用";
        case 2:return "转正";
        case 3:return "挂靠";
        case 4:return "自动离职";
        case 5:return "辞退";
    }
}

// 获取政治面貌
function getPolitics(i){
    switch (i){
        case 1:return "共产党员";
        case 2:return "中共预备党员";
        case 3:return "共青团员";
        case 4:return "民主党派";
        case 5:return "群众";
    }
}

// 获取学历
function getEduLevel(i){
    switch (i){
        case 1:return "高中";
        case 2:return "专科";
        case 3:return "本科";
        case 4:return "硕士";
        case 5:return "博士";
    }
}


function getDept(id) {
    for (let i = 0; i < deptList.length; i++) {
        if(deptList[i]["depID"]==id) {
            return deptList[i]["depName"];
        }
    }
}

function getPost(id) {
    for (let i = 0; i < postList.length; i++) {
        if(postList[i]["id"]==id) {
            return postList[i]["name"];
        }
    }
}

function WriteTitleBox(data) {
    for (let i = 0; i < data.length; i++) {
        $("#title").append("<option value='" + data[i]["id"] + "'>" + data[i]["titleName"] + "</option>");
    }
}

function getTitleRank(rank) {
    switch (rank) {
        case 1:
            return "正高职称";
        case 2:
            return "副高职称";
        case  3:
            return "中级职称";
        case  4:
            return "初级职称";
    }
}