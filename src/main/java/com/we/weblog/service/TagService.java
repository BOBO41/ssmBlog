package com.we.weblog.service;


import com.we.weblog.domain.Metas;
import com.we.weblog.domain.Select;
import com.we.weblog.domain.modal.Types;
import com.we.weblog.mapping.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {


    private TagMapper tagMapper;

    @Autowired
    TagService(TagMapper tagMapper){
        this.tagMapper = tagMapper;
    }

    public List<String> getTotalTagsName(){
        return tagMapper.selectAllKindTags();
    }

    public void deleteTag(int uid){
        tagMapper.deleteTagById(uid);
    }

     // 删除category from metas
    public int deleteMetas(String name){ return tagMapper.deleteCategoryByName(name); }


    /**
     * 分类管理删除标签
      * @param tagName
     * @return
     */
    public int clearTagData(String tagName) {
       int result = tagMapper.deleteTagByName(tagName);
       if (result > 0) {
           tagMapper.deleleTagFromContext(tagName);
       } else {
           return 0;
       }
       return 1;
    }

    /**
     * 添加分类
     * @param name
     * @return
     */
    public int addCategory(String name) {
        if (name == null)
            return 0;
        Metas category = new Metas();
        category.setName(name);
        category.setType(Types.MATE_CATEGOTY);
        return tagMapper.insertCatgory(category);

    }


    public List<String> getMates() {
       List<String> categories = new ArrayList<>();
       List<Metas> metas =  tagMapper.selectCategories();

       for (Metas meta: metas) {
           categories.add(meta.getName());
       }
       return categories;

    }



    public List<Select> getCategories(){

        List<Select> selects = new ArrayList<>();
        List<String> categories = tagMapper.getAllCategories();

        for (String category:categories) {
            Select select = new Select();
            select.setText(category);
            select.setValue(category);
            selects.add(select);
        }

        return selects;
    }
}
