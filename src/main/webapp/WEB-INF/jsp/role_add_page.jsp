<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>新增角色</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame//static/image/code.png">
    <style>
        .layui-margin-top {
            margin-top: 20px;
        }
    </style>
</head>
<body class="body">
<div class="layui-container layui-margin-top">
    <div class="layui-row">
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>新增角色</legend>
            </fieldset>

            <form class="layui-form layui-form-pane" action="/role/add" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">角色名</label>
                    <div class="layui-input-block">
                        <input type="text" name="roleName" required  lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
                        <div class="layui-form-mid layui-word-aux"></div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">排序</label>
                    <div class="layui-input-block">
                        <input type="text" name="sort" required  lay-verify="number" placeholder="请输入排序" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-block">
                        <input checked="" name="isAvailable" lay-skin="switch" lay-filter="switchTest" title="是否可用" type="checkbox">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">文本域</label>
                    <div class="layui-input-block">
                        <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>

                <div class="layui-form-item layui-hide">
                    <button class="layui-btn" lay-submit lay-filter="btnCommit" id="btnCommit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/frame/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , upload = layui.upload
            , $ = layui.jquery;
    });
</script>
</body>
</html>
