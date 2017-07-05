
import random
import time
import sys
import time
import thread
import httplib, urllib
import random
import uuid
import json

addr="localhost"
port=8080

class Transaction(object):
    def __init__(self):
        pass

    def run(self):
    	httpClient = None
        try:
            headers = {"Content-type": "application/json;charset=UTF-8", "Accept": "application/json, text/plain, */*"}
            params = json.dumps({'word': 'bas'})
            start_timer = time.time()
            httpClient = httplib.HTTPConnection(addr, port, timeout=5)
            httpClient.request("POST", "/wiki-pages/suggestWord.do", params, headers)

            response = httpClient.getresponse()
            latency = time.time() - start_timer
            self.custom_timers['Example_Homepage'] = latency
        except Exception, e:
            print e
        finally:
            if httpClient:
                httpClient.close()
if __name__ == '__main__':
    trans = Transaction()
    trans.run()
    print trans.custom_timers
