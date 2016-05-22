#include <map>
#include <string>
#include <fstream>
#include <hash_set>

using namespace std;

BOOL isInitialized = FALSE;
//map<string,string> functionName;
//map<string,string>::iterator it;

CRITICAL_SECTION g_cs;
hash_set<const char*> functionName;
hash_set<const char*>::iterator it;

void getFunctionName(const char* str,BOOL isRun)
{
	if(!isInitialized)
	{
		InitializeCriticalSection(&g_cs);
		isInitialized = TRUE;
	}
	//it = functionName.find(str);
	if(isRun)
		return;
	else
	{
		EnterCriticalSection(&g_cs);
		//functionName[str] = str;
		functionName.insert(str);
		LeaveCriticalSection(&g_cs);
	}
}

void printFunctionName()
{
	ofstream fout("functionList.txt");
	it = functionName.begin();
	if(fout.bad())
	{
		exit(0);
	}
	while(it != functionName.end())
	{
		fout<<*it<<endl;
		it++;
	}
	fout.close();
}