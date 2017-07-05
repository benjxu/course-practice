#! /usr/bin/env python  
#coding=utf-8  
import redis  
import MySQLdb
import sys

reload(sys) 
sys.setdefaultencoding('utf8')

# 连接，可选不同数据库  
r = redis.Redis(host='127.0.0.1', port=6379, db=1)

# modify to use your own database
conn= MySQLdb.connect(
        host='localhost',
        port = 3306,
        user='root',
        passwd='',
        db ='',
        )

cur = conn.cursor()
aa = cur.execute("select title from pages")
titles = cur.fetchmany(aa)
for title in titles:
	# Remove wikipedia:, split word by space
    for word in title[0].split(' '):
        # Add zadd calls
        if word.find('Wikipedia:') == -1:
            r.zadd('wordset', word ,0)
    # End
cur.close()
conn.commit()
conn.close()



