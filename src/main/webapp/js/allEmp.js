// 获取用户数据
function showEmpData() {
    axios({
        method: "post",
        url: getProjectPath() + "/allInfoEmp"
    }).then(function (resp) {
        if (resp.data != null) {
            dataEmp = eval(resp.data);
            allCount = dataEmp.length;
            Total_pages=allCount / page_number;
            WriteList(dataEmp,0,page_number);
            page_id=1;
        } else {
            let bigImg = document.createElement("img");
            bigImg.src = "../imgs/no_data.png";
            bigImg.width = 520;
            document.getElementById('myp').appendChild(bigImg);
        }
    })
}

// 显示用户数据
function WriteList(data, start, end) {
    if(start>=allCount || end<=0){
        return;
    }
    page_id = end/page_number;
    let strHtml = "";
    if (data == "") {
    } else {
        let empList = data;
        let manager = localStorage.getItem("manager");
        strHtml += "<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">	";
        for (let i = 0; i < empList.length; i++) {
            if(i>=start && i<end) {
                strHtml += "<tr class=\"td_" + (i % 2 + 1) + "\">";
                strHtml += "<td width=\"6%\">" + empList[i]["id"] + "</td>";
                strHtml += "<td width=\"6%\">" + empList[i]["name"] + "</td>";
                strHtml += "<td width=\"6%\">" + getGender(empList[i]["gender"]) + "</td>";
                strHtml += "<td width=\"6%\">" + empList[i]["age"] + "</td>";
                strHtml += "<td width=\"6%\">" + getEduLevel(empList[i]["eduLevel"]) + "</td>";
                strHtml += "<td width=\"6%\">" + empList[i]["salary"] + "</td>";
                strHtml += "<td width=\"8%\">" + getStatus(empList[i]["status"]) + "</td>";
                strHtml += "<td width=\"9%\">" + getDept(empList[i]["deptId"]) + "</td>";
                strHtml += "<td width=\"9%\">" + getPost(empList[i]["postId"]) + "</td>";
                strHtml += "<td width=\"9%\">" + getTitle(empList[i]["titleId"]) + "</td>";
                strHtml += "<td width=\"10%\">" + getPolitics(empList[i]["politics"]) + "</td>";
                strHtml += "<td width=\"10%\">" + empList[i]["induction"] + "</td>";
                strHtml += "<td><a href=\"JavaScript:showMore(" + empList[i]["id"] + ")\"><img class='img' src='../imgs/check.png'></a>";
                if (manager === "true") {
                    strHtml += "<a href=\"JavaScript:edit(" + empList[i]["id"] + ")\"><img class='img' src='../imgs/edit.png'></a>";
                    strHtml += "<a href=\"JavaScript:delData(" + empList[i]["id"] + ",'" + empList[i]["name"] + "')\"><img class='img' src='../imgs/del.png'></a>";
                }
            }
        }
        strHtml += "</td></tr></table>";
    }
    document.getElementById("coursesSpan").innerHTML = strHtml;
    createPage();
}

function getTitle(id) {
    for (let i = 0; i < dataTitle.length; i++) {
        if(dataTitle[i]["id"] == id){
            return dataTitle[i]["titleName"];
        }
    }
}

// 查看
function showMore(id) {
    location.href = "empInfo.html?id=" + id;
}

// 修改
function edit(id) {
    location.href = "addEmp.html?id=" + id;
}

// 删除
function delData(id, name) {
    let flag = confirm("确定将" + name + "的信息删除吗");
    if (flag) {
        axios({
            method: "post",
            url: getProjectPath() + "/delEmp",
            params: {
                'id': id
            }
        }).then(function (resp) {
            if (resp.data == 0) {
                alert("删除失败");
            } else {
                alert("删除成功");
            }
            showEmpData(); // 刷新
        })
    }
}

// 排序
function ordered(s, t) {
    for (let i = 0; i < dataEmp.length; i++) {
        for (let j = 0; j < dataEmp.length - 1 - i; j++) {
            let flag;
            if (t % 2 == 0) {
                flag = dataEmp[j][s] > dataEmp[j + 1][s];
            } else {
                flag = dataEmp[j][s] < dataEmp[j + 1][s];
            }
            if (flag > 0) {
                let temp = dataEmp[j];
                dataEmp[j] = dataEmp[j + 1];
                dataEmp[j + 1] = temp;
            }
        }
    }
    WriteList(dataEmp, 0, page_number);
}
// 姓名排序
function orderByName(t) {
    for (let i = 0; i < dataEmp.length; i++) {
        for (let j = 0; j < dataEmp.length - 1 - i; j++) {
            let flag;
            if (t % 2 == 0) {
                flag = dataEmp[j]["name"].localeCompare(dataEmp[j + 1]["name"]);
            } else {
                flag = dataEmp[j + 1]["name"].localeCompare(dataEmp[j]["name"]);
            }
            if (flag > 0) {
                let temp = dataEmp[j];
                dataEmp[j] = dataEmp[j + 1];
                dataEmp[j + 1] = temp;
            }
        }
    }
    WriteList(dataEmp, 0, page_number);
}


// 排序图标变化
function orderImg(ele, num) {
    let son = ele.firstElementChild;
    let grandson1 = son.firstElementChild; // 升序对象
    let grandson2 = son.lastElementChild; // 降序对象
    if (num % 2 == 0) {
        grandson1.style.borderBottomColor = "#357fff";
        if(flag_last){
            if(grandson_last != null){
                grandson_last.style.borderBottomColor = "#c0c4cc";
            }
        }else{
            grandson_last.style.borderTopColor = "#c0c4cc";
        }
        grandson_last = grandson1;
        flag_last = true;
        // grandson2.style.borderTopColor = "#c0c4cc";
    } else {
        // grandson1.style.borderBottomColor = "#c0c4cc";
        grandson2.style.borderTopColor = "#357fff";
        if(flag_last){
            grandson_last.style.borderBottomColor = "#c0c4cc";
        }else{
            grandson_last.style.borderTopColor = "#c0c4cc";
        }
        grandson_last = grandson2;
        flag_last = false;
    }
}