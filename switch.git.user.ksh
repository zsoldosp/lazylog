#~/bin/sh

login=""
email=""
if [[ `git config user.name` = "mileszrobi" ]]; then
    login=zsoldosp
    email=peter.zsoldos@gmail.com
else
    login=mileszrobi
    email=robert@milesz.hu
fi
git config user.name "$login"
git config user.email "$email"

echo git user changed to `git config user.name`
