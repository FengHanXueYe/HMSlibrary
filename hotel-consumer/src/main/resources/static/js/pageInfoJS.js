

// 加载数据字典下拉框
function loadSelect(url,code, e){
    $.get(url,"code="+code,function(result){
        e.append("<option value='-1'>--请选择--</option>");
        $.each(result, function (index,item) {
            e.append("<option value='"+item.valueId+"'>"+item.valueName+"</option>");
        })
    })
}

// 加载普通
function loadH(url,e){
    $.post(url,function(result){
        e.append("<option value='-1'>--请选择--</option>");
        $.each(result, function (index,item) {
            e.append("<option value='"+item.mrId+"'>"+item.mrName+"</option>");
        })
    })
}

// 加载列表
function loadMembers(FormId,url,pageNumController,pageNum,strSZ){
    // 表单序列化
    var data = $("#"+FormId).serialize();
    $.post(url,data+"&"+pageNumController+"="+pageNum,function (result) {
        var list = result.list;

        // 加载分页
        pageInfoUtil(result);
        $("#listContainer").html("");

        var html = "";
        html +=  "<table class='table table-striped table-hover'>"
            +"<tr class='info'>"
        for(var i = 0; i<strSZ.length; i++){
            html+= "<th>"+strSZ[i]+"</th>";
        }
        html+="</tr>";
        $.each(list,function (index,item) {
            html += "<tr >"
                +"<td>"+item.mId+"</td>"
                +"<td>"+item.mName+"</td>"
                +"<td>"+item.mSFZtypeName+"</td>"
                +"<td>"+item.mAddress+"</td>"
                +"<td>"+item.mTel+"</td>"
                +"<td>"+item.mMembershipRank.mrName+"</td>"
                +"<td class='col-md-1 '>"
                +"<a href='javascript:void(0)' onclick='detailOperator("+item.oId+")'><span class='glyphicon glyphicon-eye-open ' title='查看' aria-hidden='true'></span></a> "
                +"<a href='javascript:void(0)' onclick='updateOperator("+item.oId+")'><span class='glyphicon glyphicon-pencil ' title='编辑' aria-hidden='true'></span></a> "
                +"<a href='javascript:void(0)' onclick='deleteOperator("+item.oId+",\""+item.oName+"\")'><span class='glyphicon glyphicon-trash' title='删除' aria-hidden='true'></span></a> "
                +"</td>"
                +"</tr>";
        })
        html += "</table>";
        $("#listContainer").html(html);
    })
}


// 点击分页事件
function clickPage(pageNum) {
    var sz = ["编号","会员姓名","证件类型","住址","电话","会员等级","操作"];
    loadMembers("selectForm","ajaxQueryAllMember","pageNum",pageNum,sz);
}

// 加载分页
function pageInfoUtil(result) {
    $("ul[id='fengye']").html("");
    var pagePre = 1;
    if(result.pageNo<=1){
        pagePre = 1;
    }else{
        pagePre = Number(result.pageNo)-1;
    }
    var pageNext;
    if(result.pageNo>=result.totalPageCount){
        pageNext = result.totalPageCount;
    }else{
        pageNext = Number(result.pageNo)+1;
    }
    var pageHtml = "";
    pageHtml+="<li no='"+result.pageNo+"'>"
        +"<a href='javascript:void(0)' onclick='clickPage("+pagePre+")'  aria-label='Previous' >"
        +"<span aria-hidden='true'>&laquo;</span>"
        +"</a>"
        +"</li>";
    $.each(result.navigatepageNums, function (index,item) {
        if(result.pageNo==item||result.ttotalPageCount==1){
            pageHtml+="<li class='active' th:no='"+item+"'><a href='javascript:void(0)' onclick='clickPage("+item+")' >"+item+"</a></li>";
        }else{
            pageHtml+="<li class='' th:no='"+item+"'><a href='javascript:void(0)' onclick='clickPage("+item+")'>"+item+"</a></li>";
        }
    })
    pageHtml+="<li th:no='"+pageNext+"'><a href='javascript:void(0)' aria-label='Next' onclick='clickPage("+pageNext+")'>"
        +"<span aria-hidden='true'>&raquo;</span>"
        +"</a>"
        +"</li>";
    $("ul[id='fengye']").html(pageHtml);

}