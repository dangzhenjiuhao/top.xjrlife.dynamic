<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户列表</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <!--<link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">-->
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">


    <%--<style>--%>
        <%--.layui-table-cell {--%>
            <%--height: auto;--%>
            <%--line-height: 28px;--%>
        <%--}--%>
    <%--</style>--%>
</head>
<body class="body">

<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
        <a class="layui-btn btn-add btn-default" id="btn-add">添加</a>
        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
    </span>
    <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" placeholder="请输入搜索条件" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span>
</div>

<!-- 表格 -->
<script type="text/html" id="userTypeTpl">
    {{# if(d.userType===0){ }}
    普通用户
    {{# }else if(d.userType===1){ }}
    管理员
    {{# } }}
</script>
<script type="text/html" id="isAvailableTpl">
    {{# if(d.isAvailable===0){ }}
    已禁用
    {{# }else if(d.isAvailable===1){ }}
    已启用
    {{# } }}
</script>
<div id="dateTable"></div>

<script type="text/javascript" src="/frame/layui/layui.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript">

    // layui方法
    layui.use(['table', 'form', 'layer', 'vip_table', 'vip_tab'], function () {

        // 操作对象
        var form = layui.form
            , table = layui.table
            , layer = layui.layer
            , vipTable = layui.vip_table
            , vipTab = layui.vip_tab
            , $ = layui.jquery;

        // 表格渲染
        var tableIns = table.render({
            elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）
            , height: vipTable.getFullHeight()    //容器高度
            , cols: [[                  //标题栏
                {checkbox: true, sort: true, fixed: true, space: true}
                , {field: 'id', title: 'ID', width: 80}
                , {field: 'loginName', title: '登录名', width: 120, align: 'center'}
                , {field: 'userName', title: '用户名', width: 120, align: 'center'}
                , {field: 'userType', title: '类型', width: 80, templet: '#userTypeTpl', align: 'center'}
                , {field: 'mobile', title: '手机', width: 120, align: 'center'}
                , {field: 'headImgPath', title: '头像', width: 180,templet:'<div><img width="40" height="40" src="{{ d.headImgPath}}"></div>', align: 'center' }
                , {field: 'isAvailable', title: '状态', width: 90, templet: '#isAvailableTpl', align: 'center'}
                , {field: 'sort', title: '排序', width: 70, align: 'center'}
                , {field: 'createTime', title: '创建时间', width: 180, align: 'center'}
                , {field: 'lastLoginTime', title: '上一次登录时间', width: 180, align: 'center'}
                , {field: 'remark', title: '备注', width: 300, align: 'center'}
                , {fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#barOption', align: 'center'} //这里的toolbar值是模板元素的选择器
            ]]
            , id: 'dataCheck'
            , url: '/user/list'
            , method: 'get'
            , page: true
            , limits: [10, 30, 60, 90, 150, 300]
            , limit: 10 //默认采用30
            , loading: false
            , done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度

            }
        });

        // 获取选中行
        table.on('checkbox(dataCheck)', function (obj) {
            layer.msg('123');
            console.log(obj.checked); //当前是否选中状态
            console.log(obj.data); //选中行的相关数据
            console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
        });

        // 刷新
        $('#btn-refresh').on('click', function () {
            tableIns.reload();
        });


        // you code ...
        $("#btn-add").click(function () {
            vipTab.add('.my-body','新增用户','/user/add_page');
        });
    });
</script>
<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del">删除</a>
</script>

</body>
</html>