### 规则
    
    [项目名称]:[读权限]:[写权限]:[key]
    projectName:p:p:key  读写都是私有的
    projectName:o:p:key  读公开，写私有（默认配置）
    projectName:p:o:key  读私有，写公开
    projectName:o:o:key  读写都公开
    :::key 公有数据，不分项目