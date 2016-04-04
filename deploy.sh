#!/bin/bash

rev=$(git rev-parse --short HEAD)

cd resources/public

git init
git config user.name "Anders Furseth"
git config user.email "anders.furseth@gmail.com"

git remote add upstream "https://$GH_TOKEN@github.com/andersfurseth/dialog.git"
git fetch upstream && git reset upstream/gh-pages

# echo "example.com" > CNAME

touch .

git add -A .
git commit -m "rebuild pages at ${rev}"
git push -q upstream HEAD:gh-pages
