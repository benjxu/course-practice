from xml.etree.ElementTree import iterparse  
  
iparse = iterparse('enwiki-20170601-abstract9.xml',['start','end'])  

for event,elem in iparse:  
    if event == 'start' and elem.tag == 'feed':  
        Nodes = elem  
        #print nodes  
        break  
feed = []  
  

docs = (elem for event,elem in iparse if event == 'end' and elem.tag =='doc')  
#books = Nodes.findall('book')  
#books = elem.findall('book')  
for i in docs:  
    doc = {} 
    doc['title'] = i.find('title').text
    #print book['category']  
    doc['url'] = i.find('url').text

    doc['abstract'] = i.find('abstract').text
    feed.append(doc)  
    #print book  

    Nodes.remove(i)

print "feed:"  
i=1  
for doc in feed:  
    print 'doc%s'%i  
    #print book  
    i=i+1  
    for key in doc:  
        print '  %s : %s' % (key,doc[key])  