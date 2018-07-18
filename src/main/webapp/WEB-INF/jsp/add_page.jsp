<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame//static/image/code.png">
</head>
<body class="body">
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md2">
        </div>
        <div class="layui-col-md8">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">登录名</label>
                    <div class="layui-input-block">
                        <input type="text" name="loginName" required  lay-verify="required" placeholder="请输入登录名" autocomplete="off" class="layui-input">
                        <div class="layui-form-mid layui-word-aux"></div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="username" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="username" lay-verify="required" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓各</label>
                    <div class="layui-input-inline">
                        <input type="text" name="password" placeholder="请输入真实姓各" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="password" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-inline">
                        <button class="layui-btn test" lay-data="{url: '/a/'}">上传头像</button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="isAvailable" lay-skin="switch">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="" lay-filter="sub">提交</button>
                </div>
            </form>
        </div>
        <div class="layui-col-md2">
        </div>
    </div>
</div>


<script src="/frame//layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , element = layui.element;

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(sub)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        });

        // you code ...


    });
</script>
</body>
</html>
