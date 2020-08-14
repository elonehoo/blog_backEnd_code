package com.inet.codeBase.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.Blog;
import com.inet.codeBase.beans.ShowBlog;
import com.inet.codeBase.beans.User;
import com.inet.codeBase.service.BlogService;
import com.inet.codeBase.utils.Result;
import com.inet.codeBase.utils.UUIDUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 上传图片
     * @return
     */
    @PostMapping("/picture")
    @CrossOrigin
    public Result getPicture(@PathVariable MultipartFile file){
        if(file.isEmpty()){
            return new Result(null,"请选择文件",104);
        }
        //文件名
        String fileName = file.getOriginalFilename();
        //后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //文件存储位置  我放在了我的项目下
        String path = "D:\\8.items\\web-vue-app\\images";
        //图片名
        fileName= UUIDUtils.getId() +suffixName;
        //存放图片，获取项目得名字
        File dest = new File(path+"/"+fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        //判断是否上传成功
        try {
            file.transferTo(dest);
            String url="./images/"+fileName;
            return new Result(url,"上传成功",100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(null,"上传失败",104);
    }
    /**
     * 上传博客
     */
    @PostMapping("/insert")
    @CrossOrigin
    public Result getInsert(@RequestBody HashMap<String,Object> map){
        //获取前端的数据
        //创建博客序号
        String id = UUIDUtils.getId();
        //图片路径
        String image = (String) map.get("image");
        //获取内容
        String contents = (String) map.get("contents");
        //获取标题
        String title = (String) map.get("headline");
        //获取类别
        String property = (String) map.get("property");
        //获取类型
        String typeId = (String) map.get("classty");
        //设置浏览次数
        int views = 0;
        //是否开启赞赏
        Boolean admire = false;
        //是否开启版权
        Boolean copyright = false;
        //是否开启评论
        Boolean discuss = false;
        //是否发布
        Boolean publish;
        String issue = (String) map.get("publish");
        if (issue.equals("true")){
            publish = true;
        }else {
            publish = false;
        }
        //发布时间
        //创建时间
        Date creationTime = new Date();
        //获取描述
        String describe = (String) map.get("describe");
        //获取用户信息
        String token = (String) map.get("token");
        //判断token令牌是否为空
        token = token == null ? "" : token;
        //从NoSQL中取出数据
        User user = (User) redisTemplate.opsForValue().get(token);
        //判断数据是否为空
        if (user == null){
            return new Result(null,"获取登录用户信息失败",104);
        }
        //将数据的登录时间设置成为30分钟
        redisTemplate.expire(token,30L, TimeUnit.MINUTES);
        //设置评论数量
        int commentCount = 0;

        //设置实体类
        Blog blog = new Blog();
        //设置参数
        blog.setBlogId(id);
        blog.setBlogTitle(title);
        blog.setBlogContent(contents);
        blog.setBlogFirstFigure(image);
        blog.setBlogSign(property);
        blog.setBlogViews(views);
        blog.setBlogAdmire(admire);
        blog.setBlogCopyright(copyright);
        blog.setBlogDiscuss(discuss);
        blog.setBlogPublish(publish);
        blog.setBlogCreationTime(creationTime);
        blog.setBlogModificationTime(creationTime);
        blog.setBlogDescribe(describe);
        blog.setTypeId(typeId);
        blog.setUserId(user.getUserId());
        blog.setCommentCount(commentCount);

        //使用插入的方法
        String message = blogService.insert(blog);
        return new Result(message,"博客信息",100);
    }

    /**
     * 查询博客
     */
    @PostMapping("/select")
    @CrossOrigin
    public Result getSelect(@RequestBody HashMap<String,Object> map){
        String cond = (String) map.get("condition");
        //获取页数
        int pageNum = (int) map.get("pageNum");
        //设置一页显示多少条数据
        int pageSize = 10;
        if (cond.equals("") == true){
            List<ShowBlog> lists = blogService.pageAll(pageNum,pageSize);
            return new Result(lists,"分页请求",100);
        }else {
            Boolean condition;
            if (cond.equals("true")){
                condition = true;
            }else {
                condition = false;
            }
            List<ShowBlog> lists = blogService.pageByCondition(condition,pageNum,pageSize);
            return new Result(lists,"条件查询",100);
        }
    }

    /**
     * 修改博客是否上架还是下架
     */
    @PostMapping("/undercarriage")
    @CrossOrigin
    public Result getUndercarriage(@RequestBody HashMap<String,Object> map){
        //获取序号
        String uuid = (String) map.get("uuid");
        //判断是上架还是下架
        String pub = (String) map.get("publish");
        Boolean publish;
        if (pub.equals("true")){
            publish = true;
        }else {
            publish = false;
        }
        //查询该序号的博客
        Blog blog = blogService.selectById(uuid);
        //修改上架模式
        blog.setBlogPublish(publish);
        int strip = blogService.updateUndercarriage(blog);
        if (strip != 1){
            return new Result("失败","修改请求",104);
        }
        return new Result("成功","修改请求",100);
    }
    /**
     * 删除博客
     */
    @PostMapping("/delete")
    @CrossOrigin
    public Result getDelete(@RequestBody HashMap<String,Object> map){
        //获取需要删除的序号
        String uuid = (String) map.get("uuid");
        int strip = blogService.deleteById(uuid);
        if (strip != 1){
            return new Result("删除失败","删除请求",104);
        }else {
            return new Result("删除成功","删除请求",100);
        }
    }

    /**
     * 查看需要修改的博客
     * @param map
     * @return
     */
    @PostMapping("/session")
    @CrossOrigin
    public Result getSession(@RequestBody HashMap<String,Object> map){
        String token = (String) map.get("token");
        Blog blog = blogService.selectById(token);
        return new Result(blog,"修改查看博客",100);
    }

    /**
     * 修改博客
     * @param map
     * @return
     */
    @PostMapping("/update")
    @CrossOrigin
    public Result getUpdate(@RequestBody HashMap<String,Object> map){
        //获取是发布还是保存
        Boolean publish = (Boolean) map.get("publish");
        //获取需要修改的博客序号
        String uuid = (String) map.get("uuid");
        //通过博客序号查询该博客的具体信息
        Blog blog = blogService.selectById(uuid);
        //获取属性（原创，搬运，翻译）
        String sign = (String) map.get("sign");
        //获取类别序号
        String typeId = (String) map.get("typeId");
        //获取标题
        String title = (String) map.get("title");
        //获取内容
        String content = (String) map.get("content");
        //设置时间，规定为修改时间
        Date modificationTime = new Date();
        //获取首图的地址
        String image = (String) map.get("image");
        if (! image.equals("")){
            //修改首图的地址
            blog.setBlogFirstFigure(image);
        }
        //获取描述
        String describe = (String) map.get("describe");

        //修改博客中可能被修改的内容
        //修改发布的情况
        blog.setBlogPublish(publish);
        //修改属性
        blog.setBlogSign(sign);
        //修改类别
        blog.setTypeId(typeId);
        //修改标题
        blog.setBlogTitle(title);
        //修改内容
        blog.setBlogContent(content);
        //设置修改时间
        blog.setBlogModificationTime(modificationTime);

        //修改描述
        blog.setBlogDescribe(describe);
        //进行修改
        int strip = blogService.updateById(blog);
        if (strip != 1){
            return new Result("修改失败","修改博客",104);
        }else {
            return new Result("修改成功","修改博客",100);
        }
    }

    /**
     * 通过分类得序号和已经发布得条件查询博客
     * @param map
     * @return
     */
    @PostMapping("/classify")
    @CrossOrigin
    public Result getClassify(@RequestBody HashMap<String,Object> map){
        Map<String,Object> condition = new HashMap<>();
        //判断查询条件
        String typeId = (String) map.get("typeId");
        if (!typeId.equals("")){
            condition.put("type_id",typeId);
        }
        //只查询已发布得
        Boolean publish = true;
        condition.put("blog_publish",publish);
        //查询页数
        int pageNum = (int) map.get("pageNum");
        //设置一页显示得内容
        int pageSize = 5;
        Page<Blog> blogPage = new Page<>(pageNum, pageSize);
        IPage<Blog> blogs = blogService.selectByCondition(blogPage,condition);
        return new Result(blogs,"首页请求",100);
    }

    /**
     * 通过序号查询某一个博客
     * @param map
     * @return
     */
    @PostMapping("/one")
    @CrossOrigin
    public Result getOne(@RequestBody HashMap<String,Object> map){
        String blogId = (String) map.get("blogId");
        Blog blog = blogService.selectById(blogId);
        blog.setBlogViews(blog.getBlogViews() + 1);
        return new Result(blog,"查看博客",100);
    }
}
