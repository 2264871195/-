//验证注册界面的数据的有效性
function checkRegister(form) {
    //名字
    var name=from.name.value.trim();
    if (name==null||name==""){
        alert("用户名不能为空");
        form.name.focus();
        return false;
    }
    return true;
}