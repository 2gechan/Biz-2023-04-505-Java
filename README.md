:horse: Java 개발자 도구
1. jdk 17 설치 : java.com
2. 7zip 설치 : 7zip.org
3. D2coding font 설치
4. eclipse 설치 : eclipse.org

## git repository 생성
1. 새로운 컴퓨터에서 최초로 github를 사용하고자 할때 설정
```bash
git config --global user.name 2gechan
git config --global user.email 7532602@gmail.com
```

2. local Repository 생성하고자 할 때 : 
```bash
git init
```

3. Reopository에 대한 설명을 하기 위하여 README.md 파일 생성하기

4. 원격 repository 별명 설정하기
```bash
git remote add origin https://github.com/2gechan/Biz-2023-04-505-Java.git
```

### 기존의 repository에 계속해서 update 하고자 할 때

5. 현재 폴더의 파일과 폴더를 local Repository에 압축, 암호화하여 보관하기
```bash
git add .
```

6. 현재 local Repsitory에 보관된 압축된 데이터에 대한 comment를 추가하기
```bash
git commit -m "first"
```
7. local Repository에 보관된 압축된 데이터를 원격 Repository로 push
```bash
git push -u origin master
git push
```

```bash
git init
git add README.md
git commit -m "first commit"
git branch -M master
git remote add origin https://github.com/2gechan/Biz-2023-04-505-Java.git
git push -u origin master
```