# 在线考试系统
2020-6-16 16:13 经过反复调试，项目环境配置成功，已初步运行！




2020-6-16 18：01 完成管理员登录，密码修改功能!




2020-6-17 18:08 完成管理员对教师信息的查询，添加，修改，删除，批量删除操作,以及为了对教师信息进行添加、修改功能；完成了院系的添加，查询，职称的添加，查询功能。




2020-6-19 21:03 完成院系的更新，删除；职称的更新删除，学期的新增，修改


2020-6-19 22:07 完成教师的登录验证，专业的查询，新增


2020-6-22 16:53 完成修改专业名称、添加班级、查询班级所有学生，学生信息添加


2020-7-3 22:43 完成知识点一级目录的查询，显示，添加


2020-7-4 17:50 完成二级知识点的查询、添加
在选择题查询中（防止SQL注入，转义出错，使用StringEscapeUtils.escapeHtml4进行转义）以及使用com.github.pagehelper.PageHelper分页插件进行分页处理
显示一级知识点于前台,对选择题完成添加操作（完成PageHelper.startPage原理探究）
