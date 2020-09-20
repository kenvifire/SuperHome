#使用GIT提交代码

##1 初始化一个仓库

要用Git进行版本管理，必须先初始化Git仓库，要用Git进行版本管理，必须先初始化Git仓库--git init。

我们的本地仓库由Git维护的三棵树组成：

第一个是我们的 工作目录 ，它持有实际文件；

第二个是 暂存区（Index） ，它像一个缓存区域，临时保存个人的改动；

第三个是 HEAD ，它指向我们最后一次提交的结果。

##2 .gitignore文件通用模板
在开发的过程中，总有一些自动生成的文件不需要加入到git的管理，比如maven产生的target目录，比如IntelliJ IDEA编辑器产生的.idea目录，我们可以创建一个名为 .gitignore 的文件来解决这些通用的问题

.gitignore

git add .gitignore

git commit -m 'xxx'

##3 添加远程仓库

远程仓库——和本地仓库相对独立的另一个仓库

要添加一个新的远程仓库,可以指定一个简单的名字,以便将来引用,运行 git remote add [shortname] [url]:

git remote add origin

git remote add origin git@github.com.XXX  远程仓库的名称设置为 origin （标识符）

##4 本地分支和远程分支关联

Git在本地新建分支后，可做远程分支关联。关联目的是，如果在本地分支下进行pull 和push操作时 ，便不需要指定远程的分支

git branch --set-upstream-to=origin/master master  

git remote

git log

##4 向暂存区中添加文件 git add XX

在提交之前,Git有一个暂存区(staging area),可以放入新添加的文件或者加入新的改动，一次添加多个，用空格分隔

git add .  会递归地添加当前工作目录中的所有文件

##5 保存仓库的历史记录 git commit - m 'XXX'

commit时提交的改动是上一次加入到staging area中的改动,而不是我们disk上的改动

在执行 git commit 命令之前，先执行 git diff HEAD 命令查看本次提交和上次提交之间有什么区别，确认后再提交，是一个好习惯

##6 获取最新的远程仓库分支
git pull --rebase   在工作目录中获取 (fetch) 并合并 (merge) 远端的改动

合并改动之前，可以使用git diff <source_branch> <target_branch>预览差异

git diff origin/master

##7 推送至远程仓库

git push  当前本地仓库 master 分支的内容就会被推送到GitHub的远程仓库 origin 的 master 分支

##8 git reset 回溯历史版本

git reset HEAD XXX,可以单独针对某一个文件操作: git reset HEAD - - filename, 这个- - 也可以不加
 
git reset --soft HEAD~1 将git的HEAD变了(也就是提交记录变了),但文件并没有改变，(也就是working tree并没有改变). 取消了commit的内容

git restore --staged XX

总结：

git reset --mixed id,是将git的HEAD变了(也就是提交记录变了),但文件并没有改变，(也就是working tree并没有改变). 取消了commit和add的内容.

git reset --soft id. 实际上，是git reset –mixed id 后,又做了一次git add.即取消了commit的内容.

git reset --hard id.是将git的HEAD变了,文件也变了.

按改动范围排序如下:

soft (commit) < mixed (commit + add)< hard (commit + add + local working)

git config --list








