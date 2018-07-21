<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>角色列表</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <!--<link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">-->
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">
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
<script type="text/html" id="isAvailableTpl">
    {{# if(d.isAvailable===0){ }}
    已禁用
    {{# }else if(d.isAvailable===1){ }}
    已启用
    {{# } }}
</script>

<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del">删除</a>
</script>
<div id="dateTable" lay-filter="test"></div>

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
            , even: true //开启隔行背景
            , cols: [[                  //标题栏
                {checkbox: true, sort: true, fixed: true, space: true}
                , {field: 'id', title: 'ID', width: 80}
                , {field: 'roleName', title: '角色名', width: 120, align: 'center'}
                , {field: 'isAvailable', title: '状态', width: 90, templet: '#isAvailableTpl', align: 'center'}
                , {field: 'sort', title: '排序', width: 70, align: 'center'}
                , {field: 'createTime', title: '创建时间', width: 180, align: 'center'}
                , {field: 'remark', title: '备注', width: 500, align: 'center'}
                , {fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#barOption', align: 'center'} //这里的toolbar值是模板元素的选择器
            ]]
            , id: 'dataCheck'
            , url: '/role/list'
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

        var deleteIds = [];

        // 获取选中行
        table.on('checkbox(test)', function (obj) {
            // console.log(obj.checked); //当前是否选中状态
            // console.log(obj.data); //选中行的相关数据
            // console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
            if (obj.checked){
                deleteIds.push(obj.data.id);
            }else {
                var index = deleteIds.indexOf(obj.data.id);
                if (index > -1) {
                    deleteIds.splice(index, 1);
                }
            }
        });

        //批量删除
        $('#btn-delete-all').on('click', function () {
            if (deleteIds.length <= 0){
                layer.msg("请选择要删除的记录");
            }else{
                layer.confirm('真的删除行么', function(index) {
                    $.ajax({
                        url: "/role/deletes",
                        type: "GET",
                        data: {"ids": deleteIds},
                        success: function (data) {
                            if (data.code == 200) {
                                layer.msg("批量删除成功");
                                deleteIds = [];
                                tableIns.reload();
                            } else {
                                layer.msg(data.msg);
                            }
                        },
                        traditional: true,//这里设置为true
                    });
                });
            }
        });

        // 刷新
        $('#btn-refresh').on('click', function () {
            tableIns.reload();
        });

        /*监听工具条*/
        table.on('tool(test)', function(obj){
            var data = obj.data; /*获得当前行数据*/
            var layEvent = obj.event; /*获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）*/
            var tr = obj.tr; /*获得当前行 tr 的DOM对象*/
            if(layEvent === 'detail'){

            }else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    /*向服务端发送删除指令*/
                    $.ajax({
                        url : "/role/delete",
                        type : "get",
                        data : {'id' : data.id},
                        success : function(data) {
                            if (data.code == 200) {
                                obj.del(); /*删除对应行（tr）的DOM结构，并更新缓存*/
                                layer.msg(data.msg);/*后台定义的返回值方法*/
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    });
                });
            }else if(layEvent === 'edit'){
                /**
                 如果是iframe层
                 */
                layer.open({
                    type: 2,
                    title: ['修改角色'],//'新增用户',
                    area:  ['500px', '700px'],
                    anim: 6,
                    resize: false,
                    fixed: true,
                    content: '/role/update_page?id=' + data.id,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    btn: ['提交', '取消'],
                    yes: function(index, layero){
                        var iframeWindow = window['layui-layer-iframe'+ index]
                            ,submitID = 'btnCommit'
                            ,submit = layero.find('iframe').contents().find('#'+ submitID);

                        //监听提交
                        iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                            // layer.alert(JSON.stringify(data.field), {
                            //     title: '最终的提交信息'
                            // });
                            //关闭窗口
                            layer.close(index);
                        });
                        submit.trigger('click');

                    },
                    end: function () {
                        location.reload();
                    }
                });
            }
        });

        // you code ...
        // $("#btn-add").click(function () {
        //     vipTab.add('.my-body','新增用户','/user/add_page');
        // });
        $("#btn-add").click(function () {
            /**
                如果是iframe层
            */
            layer.open({
                type: 2,
                title: ['新增角色'],//'新增用户',
                area:  ['500px', '700px'],
                anim: 6,
                resize: false,
                fixed: true,
                content: '/role/add_page',//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                btn: ['提交', '取消'],
                yes: function(index, layero){
                    var iframeWindow = window['layui-layer-iframe'+ index]
                        ,submitID = 'btnCommit'
                        ,submit = layero.find('iframe').contents().find('#'+ submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                        // layer.alert(JSON.stringify(data.field), {
                        //     title: '最终的提交信息'
                        // });
                        //关闭窗口
                        layer.close(index);
                    });
                    submit.trigger('click');

                },
                end: function () {
                    location.reload();
                }
            });
        });
    });
</script>


</body>
</html>