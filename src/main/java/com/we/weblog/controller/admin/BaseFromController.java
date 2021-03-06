package com.we.weblog.controller.admin;

import com.vue.adminlte4j.model.UIModel;
import com.we.weblog.controller.admin.form.SystemFromInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangwei
 * @date 2018/9/28 10:51
 */
@Controller
@RequestMapping("/admin/form")
public class BaseFromController {
    /**
     * 系统配置
     * @return
     */
    @GetMapping("/system")
    @ResponseBody
    public UIModel systemPage() {
        return UIModel.success().formData(new SystemFromInfo());
    }


    /**
     * 系统配置
     * @return
     */
    @GetMapping("/update")
    @ResponseBody
    public UIModel updateSystem() {
        return UIModel.success().msg("测试更新");
    }

}
