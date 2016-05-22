// mydraw.cpp : Defines the entry point for the application.
//

#include "stdafx.h"
#include "SignatureGenerator.h"
#include <InitGuid.h>
#include <dinput.h>
#include <shlobj.h>
#include <stdio.h>
#include <commdlg.h>
#include <math.h>
#include <string>
#include <map>

using namespace std;
#define MIN(a,b) ((a)<(b)?(a):(b))
#define MAX(a,b) ((a)>(b)?(a):(b))
#define MAX_LOADSTRING 100
#define m_Buffer 16
#define WhiteColorflag 255
#define BlackColorflag 0
#define BorderWidth 4
#define PI 3.14159265358
#define DrawWindowWidth 1600
#define DrawWindowHeight 800

// Global Variables:
HINSTANCE hInst;								// current instance
TCHAR szTitle[MAX_LOADSTRING];					// The title bar text
TCHAR szWindowClass[MAX_LOADSTRING];			// the main window class name
int lbuttonflag = 0;
int rbuttonflag = 0;
int points = 0;
volatile long record_nums;
map<LONG32,COLORREF> MapPointToColor;

// Forward declarations of functions included in this code module:
ATOM				MyRegisterClass(HINSTANCE hInstance);
BOOL				InitInstance(HINSTANCE, int);
LRESULT CALLBACK	WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK	About(HWND, UINT, WPARAM, LPARAM);
IDirectInputDevice8 *InitMouse(HWND hWnd,IDirectInput8 *MypDI);
BOOL ReadData(IDirectInputDevice8 *pDIDevice,void *DataBuffer,long BufferSize);
HBITMAP CopyToBitmap(LPRECT lpRect);
PBITMAPINFO CreateBitmapInfoStruct(HWND hwnd ,HBITMAP hBitmap);
int CreateBMPFile(HWND hwnd,LPTSTR pszFile,PBITMAPINFO pbi,HBITMAP hBMP,HDC hdc);
RECT GetRect(HWND hwnd);
void SetColorAndAddToMap(HDC hdc,int PointX,int PointY,COLORREF color);
HBITMAP DrawToBitmap(HDC hdc,POINT *point,int index,int Width,int Height);
int GetNewColorFlag(int colorflagbydistance);
void smooth(HDC hdc,int WidthOfBitmap,int HeightOfBitmap);
BOOL CALLBACK fun(LPCDIDEVICEINSTANCE lpddi, LPVOID pvRef);

DWORD WINAPI FunProc(
  __in  LPVOID lpParameter
);

DWORD WINAPI DrawFunProc(
  __in  LPVOID lpParameter
);

typedef POINT MyPoint;

void GetMyPoint(long x,long y);
int Show(HDC hdc,MyPoint *MyPt);

MyPoint pt[80000];
MyPoint *ptemp;
double GetDistanceToLine(int p,int q,MyPoint FirstPointOnLine,MyPoint SecondPointOnLine);

int APIENTRY _tWinMain(HINSTANCE hInstance,
                     HINSTANCE hPrevInstance,
                     LPTSTR    lpCmdLine,
                     int       nCmdShow)
{
	UNREFERENCED_PARAMETER(hPrevInstance);
	UNREFERENCED_PARAMETER(lpCmdLine);

	MSG msg;
	HACCEL hAccelTable;

	// Initialize global strings
	LoadString(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
	LoadString(hInstance, IDC_SIGNATUREGENERATOR, szWindowClass, MAX_LOADSTRING);
	MyRegisterClass(hInstance);

	// Perform application initialization:
	if (!InitInstance (hInstance, nCmdShow))
	{
		return FALSE;
	}

	
	HANDLE hThread, draw_thread;
	hThread = CreateThread(NULL,0,FunProc,NULL,0,NULL);
	draw_thread = ::CreateThread(NULL,0,DrawFunProc,NULL,0,NULL);

	hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_SIGNATUREGENERATOR));

	// Main message loop:
	while (GetMessage(&msg, NULL, 0, 0))
	{
		if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
		{
			TranslateMessage(&msg);
			DispatchMessage(&msg);
		}
	}

	return (int) msg.wParam;
}



//
//  FUNCTION: MyRegisterClass()
//
//  PURPOSE: Registers the window class.
//
//  COMMENTS:
//
//    This function and its usage are only necessary if you want this code
//    to be compatible with Win32 systems prior to the 'RegisterClassEx'
//    function that was added to Windows 95. It is important to call this function
//    so that the application will get 'well formed' small icons associated
//    with it.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
	WNDCLASSEX wcex;

	wcex.cbSize = sizeof(WNDCLASSEX);

	wcex.style			= CS_HREDRAW | CS_VREDRAW;
	wcex.lpfnWndProc	= WndProc;
	wcex.cbClsExtra		= 0;
	wcex.cbWndExtra		= 0;
	wcex.hInstance		= hInstance;
	wcex.hIcon			= LoadIcon(hInstance, MAKEINTRESOURCE(IDC_SIGNATUREGENERATOR));
	wcex.hCursor		= LoadCursor(NULL, IDC_ARROW);
	wcex.hbrBackground	= (HBRUSH)(COLOR_WINDOW+1);
	wcex.lpszMenuName	= MAKEINTRESOURCE(IDC_SIGNATUREGENERATOR);
	wcex.lpszClassName	= szWindowClass;
	wcex.hIconSm		= LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));


	return RegisterClassEx(&wcex);
}

//
//   FUNCTION: InitInstance(HINSTANCE, int)
//
//   PURPOSE: Saves instance handle and creates main window
//
//   COMMENTS:
//
//        In this function, we save the instance handle in a global variable and
//        create and display the main program window.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   HWND hWnd;

   hInst = hInstance; // Store instance handle in our global variable
   
   hWnd = CreateWindow(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, DrawWindowWidth, DrawWindowHeight, NULL, NULL, hInstance, NULL);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  FUNCTION: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  PURPOSE:  Processes messages for the main window.
//
//  WM_COMMAND	- process the application menu
//  WM_PAINT	- Paint the main window
//  WM_DESTROY	- post a quit message and return
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	int wmId, wmEvent;
	PAINTSTRUCT ps;
	HDC hdc;

	switch (message)
	{
	case WM_COMMAND:
		wmId    = LOWORD(wParam);
		wmEvent = HIWORD(wParam);
		// Parse the menu selections:
		switch (wmId)
		{
		/*case IDM_SMOOTH:
			{
				int smoothflag,currentflag;
				hdc = GetDC(hWnd);
				RECT ClientRect;
				::GetClientRect(hWnd,&ClientRect);
				for(int i=1;i<ClientRect.right-ClientRect.left;i++)
				{
					for(int j=1;j<ClientRect.bottom-ClientRect.top;j++)
					{
						smoothflag = ( GetRValue(GetPixel(hdc,i+1,j)) + GetRValue(GetPixel(hdc,i-1,j)) + GetRValue(GetPixel(hdc,i,j+1)) + GetRValue(GetPixel(hdc,i,j-1)) )/4;
						currentflag = ::GetPixel(hdc,i,j);
						if(currentflag != smoothflag)
							::SetPixel(hdc,i,j,RGB(smoothflag,smoothflag,smoothflag));
					}
				}
			}
			break;*/
		case IDM_IMAGE_IMPORT:
			{
				hdc = GetDC(hWnd);
				TCHAR szFile[MAX_PATH] = {0};
				HBITMAP hBitmap;
				//hBitmap = CopyToBitmap(&GetRect(hWnd));
				hBitmap = DrawToBitmap(hdc,pt,1,160,80);
	
				
				TCHAR folderPath[MAX_PATH] = {0};
				if(SUCCEEDED(SHGetFolderPath(NULL,CSIDL_APPDATA,NULL,0,folderPath)))
				{
					wcscat(folderPath, _T("\\ESignature"));
					_tmkdir(folderPath); 

					::GetTempFileName(folderPath,_T("BM_"),0,szFile);
					_wremove(szFile);

					_tcscat(szFile,_T(".bmp"));

				}
				else
				{
					LPTSTR FileNameTmp = _T("\\1234567.bmp");
					::GetModuleFileName(NULL,szFile,259);
					_tcscat(szFile,FileNameTmp);
				}

				hdc = GetDC(hWnd);
				PBITMAPINFO pbi = CreateBitmapInfoStruct(hWnd,hBitmap);
				CreateBMPFile(hWnd,szFile,pbi,hBitmap,hdc);
				COPYDATASTRUCT data;
				data.dwData = 1;
				data.cbData = 2*(_tcslen(szFile)+1);
				data.lpData = szFile;
				HWND hwnd = ::FindWindow(NULL,L"PDFElectronicSignature");
				DestroyWindow(hWnd);
				if(hwnd!=NULL)
				{
					::SendMessage(hwnd,WM_COPYDATA,(WPARAM)hWnd,(LPARAM)(LPVOID)&data);
				}
				
			}
			break;
		case IDM_ABOUT:
			DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
			break;
		case IDM_EXIT:
			DestroyWindow(hWnd);
			break;
		default:
			return DefWindowProc(hWnd, message, wParam, lParam);
			
		}
		break;
	case WM_PAINT:
		hdc = BeginPaint(hWnd, &ps);
		//SetWindowLong(hWnd,GWL_EXSTYLE,GetWindowLong(hWnd, GWL_EXSTYLE) | WS_EX_LAYERED);
		//::SetLayeredWindowAttributes(hWnd,RGB(255,255,255),255,LWA_ALPHA | LWA_COLORKEY);
		// TODO: Add any drawing code here...
		MapPointToColor.clear();
		EndPaint(hWnd, &ps);
		break;
	case WM_LBUTTONUP:
		
		lbuttonflag = 0;
		
			

		break;
	case WM_LBUTTONDOWN:
		lbuttonflag = 1;
		break;
	case WM_RBUTTONUP:
		rbuttonflag = 1;
		MapPointToColor.clear();
		::InvalidateRect(hWnd,NULL,TRUE);
		::UpdateWindow(hWnd);
		
		break;
	case WM_DESTROY:
		PostQuitMessage(0);
		break;

	default:
		return DefWindowProc(hWnd, message, wParam, lParam);
	}

	return 0;
}

// Message handler for about box.
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
	UNREFERENCED_PARAMETER(lParam);
	switch (message)
	{
	case WM_INITDIALOG:
		return (INT_PTR)TRUE;
		
	case WM_COMMAND:
		if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
		{
			EndDialog(hDlg, LOWORD(wParam));
			return (INT_PTR)TRUE;
		}
		break;
	}
	return (INT_PTR)FALSE;
}


IDirectInputDevice8 *InitMouse(HWND hWnd,IDirectInput8 *MypDI)
{
	IDirectInputDevice8 *pDIDMouse;
	//GUID MouseGUID;
	//MypDI->EnumDevices(DI8DEVCLASS_ALL,fun,&MouseGUID,DIEDFL_ALLDEVICES);
	
	if(FAILED(MypDI->CreateDevice(GUID_SysMouse,&pDIDMouse,NULL)))
		return NULL;
	if(FAILED(pDIDMouse->SetDataFormat(&c_dfDIMouse)))
	{
		pDIDMouse->Release();
		return NULL;
	}
	if(FAILED(pDIDMouse->SetCooperativeLevel(hWnd,DISCL_BACKGROUND |DISCL_NONEXCLUSIVE)))
	{
		pDIDMouse->Release();
		return NULL;
	}

	DIPROPDWORD prop;
	prop.diph.dwSize = sizeof(DIPROPDWORD);
	prop.diph.dwHeaderSize = sizeof(DIPROPHEADER);
	prop.diph.dwObj = 0;
	prop.diph.dwHow = DIPH_DEVICE;
	prop.dwData = m_Buffer;
	if(FAILED(pDIDMouse->SetProperty(DIPROP_BUFFERSIZE,&prop.diph)))
	{
		pDIDMouse->Release();
		return NULL;
	}

	HRESULT hr = pDIDMouse->Acquire();
	if(FAILED(hr))
	{
		pDIDMouse->Release();
		return NULL;
	}
	return pDIDMouse;
}

//enum callback function
//BOOL CALLBACK fun(LPCDIDEVICEINSTANCE lpddi, LPVOID pvRef)
//{
//	*(GUID*) pvRef = lpddi->guidInstance;
//
//	::MessageBoxExW(NULL,L"",L"",NULL,NULL);
//	return DIENUM_CONTINUE;
//}

BOOL ReadData(IDirectInputDevice8 *pDIDevice,DIDEVICEOBJECTDATA *rgdod, DWORD *dwitems)
{
	HRESULT hr;
	pDIDevice->Poll();
	hr = pDIDevice->GetDeviceData(sizeof(DIDEVICEOBJECTDATA), rgdod, dwitems, 0);
	if(SUCCEEDED(hr))
		return TRUE;
	else	
		return FALSE;
}


double Point2PointDistance(double x1, double y1, double x2, double y2) {
	return sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
}

// Return 0 if the point in line
// return -1 if the point is near the firstPoint side
// return 1 if the point is near the secondpoint side
int PointInLine(double x,double y,MyPoint FirstPointOnLine,MyPoint SecondPointOnLine) {
	double p1 = FirstPointOnLine.x;
	double p2 = SecondPointOnLine.x;
	double p3 = x;
    
	if(p1 == p2) {
	    p1 = FirstPointOnLine.y;
	    p2 = SecondPointOnLine.y;
		p3 = y;
	}

	if((p3 - p1) * (p3 - p2) < 0) {
	    return 0;
	}
	if(abs(p3 - p1) > abs(p3 - p2)) {
		return 1; 
	} 
	else 
	{
		return -1;
	}
}




HWND hWnd;
DWORD WINAPI DrawFunProc(
  __in  LPVOID lpParameter
)
{
	MyPoint MousePos,OldMousePos,NextMousePos,OlderMousePos,FirstPoint,SecondPoint;
	int xmin,xmax,ymin,ymax,maxdx,maxdy;
	long k = record_nums, i=2, lastIndex = 1;
	hWnd = FindWindow(szWindowClass,NULL);
	HDC hdc = GetDC(hWnd);
	int colorflag,NewColorFlag=WhiteColorflag;
	COLORREF color;
	double border_distance, distance,dnext,dold, a, b, aNext, bNext, aOld, bOld, DistanceToOldPoint ,DistanceToPoint;
	double view_width, view_x_width, view_y_width, width, y_width, x_width, pressure;
	//FILE *fp = fopen("22.txt", "w");
	//OldMousePos.x = pt[0].x;
	//OldMousePos.y = pt[0].y;
	while(true)
	{
		Sleep(1);
		k = record_nums;
		if(rbuttonflag == 1)
		{
			rbuttonflag = 0;
			i+=2;
		}
		if(lbuttonflag == 0)
		{
			lbuttonflag = 2;
			i+=2;
		}
		if (i < k-1)
		{
			while(i<k-1)
			{
				MousePos.x = pt[i].x;
				MousePos.y = pt[i].y;
				OldMousePos.x = pt[i-1].x;
				OldMousePos.y = pt[i-1].y;
				OlderMousePos.x = pt[lastIndex].x; 
				OlderMousePos.y = pt[lastIndex].y; 
				i++;

				double iToLast = Point2PointDistance(MousePos.x, MousePos.y, OlderMousePos.x, OlderMousePos.y);
				double toLine = ::GetDistanceToLine(OldMousePos.x,OldMousePos.y,OlderMousePos,MousePos);

				if(iToLast < 5 && toLine <= 1) 
				{
					//Skip the point
					continue;					
				}  

				lastIndex = i - 1;

				if(MousePos.x == -1 || OldMousePos.x == -1) {
					if(!(OldMousePos.x == OlderMousePos.x && OldMousePos.y == OlderMousePos.y) && MousePos.x == -1) {
						MousePos = OldMousePos;

					} else 
					{
						continue;
					}
				}

				OldMousePos = OlderMousePos;
				if(MousePos.x == -1 || OldMousePos.x == -1) {
					continue;
				}

				width = 2.0;
				pressure = 200;
				view_width = width + 1;

				xmin = MIN(MousePos.x,OldMousePos.x);
				xmax = MAX(MousePos.x,OldMousePos.x);
				ymin = MIN(MousePos.y,OldMousePos.y);
				ymax = MAX(MousePos.y,OldMousePos.y);
				for(int p=xmin-width*2; p<=xmax+width*2; p++)
				{
					for(int q=ymin-width*2; q<=ymax+width*2; q++)
				   {						
						distance = ::GetDistanceToLine(p,q,OldMousePos,MousePos);
						if(distance <= width)
						{
							colorflag = BlackColorflag;
							NewColorFlag = GetNewColorFlag(colorflag);
							color = RGB(NewColorFlag,NewColorFlag,NewColorFlag);
							SetColorAndAddToMap(hdc,p,q,color);
						}
						else
						{
							colorflag = (distance - width)*pressure;
							NewColorFlag = GetNewColorFlag(colorflag);
							color = RGB(NewColorFlag,NewColorFlag,NewColorFlag);
							SetColorAndAddToMap(hdc,p,q,color);
						}
					}

				}

			}
			//fprintf(fp, "%d\n", k);
		}
	}
	
	//fclose(fp);
	ReleaseDC(hWnd,hdc);
	FreeConsole();
}



void SetColorAndAddToMap (HDC hdc,int PointX,int PointY,COLORREF color)
{
	LONG32 lx = PointX;
	LONG32 hash = (lx<<16) + PointY;
	std::map<LONG32,COLORREF>::iterator iter = MapPointToColor.find(hash);
	if(iter != MapPointToColor.end())
	{
		if(GetRValue(color) < GetRValue(iter->second))
		{
			MapPointToColor[hash] = color;
			::SetPixel(hdc,PointX,PointY,color);
		}
	}
	else
	{
		if(GetRValue(color) < WhiteColorflag)
		{
			MapPointToColor[hash] = color;
			::SetPixel(hdc,PointX,PointY,color);	
		}
	}
}

DWORD WINAPI FunProc(
  __in  LPVOID lpParameter
)
{
	IDirectInput8 *pDI;
	hWnd = FindWindow(szWindowClass,NULL);
	HINSTANCE hInstance = (HINSTANCE)::GetWindowLongW(hWnd,GWL_HINSTANCE);
	HRESULT hr;
	hr = ::DirectInput8Create(hInstance,DIRECTINPUT_VERSION,IID_IDirectInput8,(void**)&pDI,NULL);
	if(FAILED(hr))
		return FALSE;
	//BROWSEINFO a;
	IDirectInputDevice8 *pDIDMouse;
	//DIDEVICEOBJECTDATA MouseData[10];
	DIDEVICEOBJECTDATA *rgdod = new DIDEVICEOBJECTDATA[16];
	LARGE_INTEGER freq,lastcount,nowcount;
	//DIMOUSESTATE MouseState;
	::QueryPerformanceFrequency(&freq);
	if((pDIDMouse = InitMouse(hWnd,pDI)) != NULL)
	{
		ptemp = pt;
		MyPoint MousePos,OldMousePos,first,second,third,fourth; 
		int flag = 1, xflag = 0, yflag = 0, points = 0, printflag = 0;
		POINT CursorPoint;
		RECT rect;
		//::GetWindowRect(hWnd,&rect);
		::GetCursorPos(&CursorPoint);
		::ScreenToClient(hWnd,&CursorPoint);
		MousePos.x = CursorPoint.x;
		MousePos.y = CursorPoint.y;
		OldMousePos = MousePos;
		FILE *fl = fopen("11.txt", "w");
		
		int p[5000], t[5000],draw[5000], z=0;
		int DrawNum = 0,PointCount = 0;
		//::QueryPerformanceCounter(&lastcount);
		//::QueryPerformanceCounter(&nowcount);
		//LONGLONG overtime = nowcount.QuadPart - lastcount.QuadPart;
		LONGLONG time = 0;
		int sq_nums = 0;
		long sq[80000];
		int oldlbuttonflag = 0;
		::QueryPerformanceCounter(&lastcount);
		while(flag)
		{
			/*Sleep(1);
			if(lbuttonflag == 1)
			{				
				
				if(OldMousePos.x != CursorPoint.x || OldMousePos.y != CursorPoint.y)
				{
					OldMousePos.x = CursorPoint.x;
					OldMousePos.y = CursorPoint.y;
					pt[record_nums].x = OldMousePos.x;
					pt[record_nums].y = OldMousePos.y;
					::InterlockedIncrement(&record_nums);
				}
				else
				{
					::GetCursorPos(&CursorPoint);
					::ScreenToClient(hWnd,&CursorPoint);
					MousePos.x = CursorPoint.x;
					MousePos.y = CursorPoint.y;
				}				
			}*/
			Sleep(1);
			if(oldlbuttonflag == 1 && lbuttonflag == 1)
			{
				DWORD dwitems = m_Buffer;
				ReadData(pDIDMouse, rgdod, &dwitems);
				oldlbuttonflag = 0;

				pt[record_nums].x = -1;
				pt[record_nums].y = -1;
				::InterlockedIncrement(&record_nums);

			}
			if(lbuttonflag == 1)
			{
				DWORD dwitems = m_Buffer;
				if(!ReadData(pDIDMouse, rgdod, &dwitems))
				{
					continue;
				}
				for(int j=0; j<dwitems; j++)
				{
					sq[sq_nums++] = rgdod[j].dwSequence;
					if(rgdod[j].dwOfs == DIMOFS_X)
					{
						if (xflag == 1)
						{
							printflag = 1;
							OldMousePos = MousePos;
							MousePos.x += rgdod[j].dwData;
						}
						else if (yflag == 1)
						{
							printflag = 1;
							MousePos.x += rgdod[j].dwData;
							OldMousePos = MousePos;
							xflag = 0;
							yflag = 0;
						}
						else
						{
							xflag = 1;
							MousePos.x += rgdod[j].dwData;
						}
					}
					else if(rgdod[j].dwOfs == DIMOFS_Y)
					{
						if (yflag == 1)
						{
							printflag = 1;
							OldMousePos = MousePos;
							MousePos.y += rgdod[j].dwData;
						}
						else if (xflag == 1)
						{
							printflag = 1;
							MousePos.y += rgdod[j].dwData;
							OldMousePos = MousePos;
							xflag = 0;
							yflag = 0;
						}
						else
						{
							yflag = 1;
							MousePos.y += rgdod[j].dwData;
						}
					}

					/*else
					{
						char a[10],b[10];
						::itoa(rgdod[j].dwOfs,a,10);
						::itoa(rgdod[j].dwData,b,10);
						::MessageBoxA(hWnd,a,b,NULL);
					}*/

					if(printflag == 1)
					{
						printflag = 0;
						points++;
						//PointCount ++;
						//::GetTickCount();
						pt[record_nums].x = OldMousePos.x;
						pt[record_nums].y = OldMousePos.y;
						::InterlockedIncrement(&record_nums);
						DrawNum++;
						

						if (record_nums > 700000)
						{
							break;
						}
						::QueryPerformanceCounter(&nowcount);
						time += (((nowcount.QuadPart - lastcount.QuadPart)*1000000)/freq.QuadPart);
						lastcount = nowcount;
						if (time >= 1000000)
						{
							fprintf(fl,"%lld ,%d\n",time, points);
							t[z] = time;
							p[z] = points;
							draw[z] = DrawNum;
							z++;
							if(z>4000)
							{
								break;
							}
							time = 0;
							points = 0;
							DrawNum = 0;
						}
					}

				}
	
			}
			else
			{
				pt[record_nums].x = -1;
				pt[record_nums].y = -1;
				::InterlockedIncrement(&record_nums);				
				
				::GetCursorPos(&CursorPoint);
				::ScreenToClient(hWnd,&CursorPoint);
				MousePos.x = CursorPoint.x;
				MousePos.y = CursorPoint.y;
				oldlbuttonflag = 1;
			}
			//::InvalidateRect(hWnd,NULL,FALSE);
			//::UpdateWindow(hWnd);
		}
		//fclose(fl);
	}
	
	return 0;
}
//Dxguid.lib;

HBITMAP CopyToBitmap(LPRECT lpRect)
{
	HDC hScrdc,hMemdc;
	HBITMAP hBitmap,hOldBitmap;
	int x1,x2,y1,y2;
	int nWidth,nHeight;
	int xScr,yScr;
	if(IsRectEmpty(lpRect) == TRUE)
		return NULL;
	hScrdc = CreateDC(TEXT("DISPLAY"),NULL,NULL,NULL);
	hMemdc = ::CreateCompatibleDC(hScrdc);
	x1 = lpRect->left;
	x2 = lpRect->right;
	y1 = lpRect->top;
	y2 = lpRect->bottom;
	xScr = ::GetDeviceCaps(hScrdc,HORZRES);
	yScr = ::GetDeviceCaps(hScrdc,VERTRES);
	nWidth = x2 - x1;
	nHeight = y2 - y1;
	hBitmap = ::CreateCompatibleBitmap(hScrdc,nWidth,nHeight);
	hOldBitmap = (HBITMAP)SelectObject(hMemdc,hBitmap);
	BitBlt(hMemdc,0,0,nWidth,nHeight,hScrdc,x1,y1,SRCCOPY);
	hBitmap = (HBITMAP)::SelectObject(hMemdc,hOldBitmap);
	::DeleteDC(hScrdc);
	::DeleteDC(hMemdc);

	return hBitmap;
}

PBITMAPINFO CreateBitmapInfoStruct(HWND hwnd ,HBITMAP hBitmap)
{
	BITMAP Bitmap;
	PBITMAPINFO pBitmapInfo;
	WORD wBits;
	if(!GetObject(hBitmap,sizeof(BITMAP),(LPSTR)&Bitmap))
		return NULL;
	
	wBits = (WORD)(Bitmap.bmPlanes*Bitmap.bmBitsPixel);
	if(wBits == 1)
		wBits = 1;
	else if(wBits <= 4)
		wBits = 4;
	else if(wBits <= 8)
		wBits = 8;
	else if(wBits <= 16)
		wBits = 16;
	else if(wBits <= 24)
		wBits = 24;
	else wBits = 32;

	if(wBits < 24)
		pBitmapInfo = (PBITMAPINFO)LocalAlloc(LPTR,sizeof(BITMAPINFOHEADER) +sizeof(RGBQUAD)*(1<<wBits));
	else
		pBitmapInfo = (PBITMAPINFO)LocalAlloc(LPTR,sizeof(BITMAPINFOHEADER));

	pBitmapInfo->bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
	pBitmapInfo->bmiHeader.biWidth = Bitmap.bmWidth;
	pBitmapInfo->bmiHeader.biHeight = Bitmap.bmHeight;
	pBitmapInfo->bmiHeader.biPlanes = Bitmap.bmPlanes;
	pBitmapInfo->bmiHeader.biBitCount = Bitmap.bmBitsPixel;

	if(wBits < 24)
		pBitmapInfo->bmiHeader.biClrUsed = (1<<wBits);
	
	pBitmapInfo->bmiHeader.biCompression = BI_RGB;
	pBitmapInfo->bmiHeader.biSizeImage = ((pBitmapInfo->bmiHeader.biWidth*wBits+31) & ~31)/8
										 *pBitmapInfo->bmiHeader.biHeight;

	pBitmapInfo->bmiHeader.biClrImportant = 0;
	return pBitmapInfo;
}

int CreateBMPFile(HWND hwnd,LPTSTR pszFile,PBITMAPINFO pbi,HBITMAP hBMP,HDC hdc)
{
	HANDLE hf;
	BITMAPFILEHEADER hdr;
	PBITMAPINFOHEADER pbih;
	LPBYTE lpBits;
	DWORD dwTotal,cb,dwTmp;
	BYTE *hp;
	
	pbih = (PBITMAPINFOHEADER)pbi;
	lpBits = (LPBYTE)GlobalAlloc(GMEM_FIXED,pbih->biSizeImage);

	if(!lpBits)
		return 0;

	if(!GetDIBits(hdc,hBMP,0,(WORD)pbih->biHeight,lpBits,pbi,DIB_RGB_COLORS))
		return 0;

	hf = ::CreateFile(pszFile,GENERIC_READ | GENERIC_WRITE,(DWORD)0,NULL,CREATE_ALWAYS,FILE_ATTRIBUTE_NORMAL,(HANDLE)NULL);
	if(hf == INVALID_HANDLE_VALUE)
		return 0;

	hdr.bfType = 0x4d42;
	hdr.bfSize = (DWORD)(sizeof(BITMAPFILEHEADER) + pbih->biSize + pbih->biClrUsed*sizeof(RGBQUAD) + pbih->biSizeImage);
	hdr.bfReserved1 = 0;
	hdr.bfReserved2 = 0;
	hdr.bfOffBits = (DWORD)sizeof(BITMAPFILEHEADER) + pbih->biSize + pbih->biClrUsed*sizeof(RGBQUAD);

	if(!WriteFile(hf,(LPVOID)&hdr,sizeof(BITMAPFILEHEADER),(LPDWORD)&dwTmp,NULL))
		return 0;
	if(!WriteFile(hf,(LPVOID)pbih,sizeof(BITMAPINFOHEADER)+pbih->biClrUsed*sizeof(RGBQUAD),(LPDWORD)&dwTmp,NULL))
		return 0;
	
	dwTotal = cb = pbih->biSizeImage;
	hp = lpBits;
	if(!WriteFile(hf,(LPSTR)hp,(int)cb,(LPDWORD)&dwTmp,NULL))
		return 0;

	if(!CloseHandle(hf))
		return 0;

	GlobalFree((HGLOBAL)lpBits);
	return 1;
}


// get the distance point(p,q) to the line (x1,y1) to (x2,y2)
// then if the line l (x1,y1) to (x2,y2)  is  y = ax + b
// the vertical line lv is y = (-1/a)x +c
// Assume the vertical point is (x, y)
// 
double GetDistanceToLine(int p,int q,MyPoint FirstPointOnLine,MyPoint SecondPointOnLine)
{
	double xv = FirstPointOnLine.x;
	double yv = FirstPointOnLine.y;
	if(FirstPointOnLine.x == SecondPointOnLine.x)
	{
		xv = FirstPointOnLine.x;
		yv = q;
	}
	else if(FirstPointOnLine.y == SecondPointOnLine.y)
	{
		xv = p;
		yv = FirstPointOnLine.y;
	}
	else
	{
		double a = (double)(FirstPointOnLine.y - SecondPointOnLine.y)/(double)(FirstPointOnLine.x - SecondPointOnLine.x);
		double b = (double)(FirstPointOnLine.y - a*FirstPointOnLine.x);
		double c = (double)(q + p / a);

		xv = double((c - b) / (a + 1 /a));
		yv = double(a * xv + b);
	}
	int pointPlace = PointInLine(xv, yv, FirstPointOnLine, SecondPointOnLine);
	if(pointPlace == 0) {
		return Point2PointDistance(p, q, xv, yv);
	} 
	else if(pointPlace == -1) 
	{
		return Point2PointDistance(p, q, FirstPointOnLine.x, FirstPointOnLine.y);
	} 
	else 
	{
		return Point2PointDistance(p, q, SecondPointOnLine.x, SecondPointOnLine.y);
	}		
}


RECT GetRect(HWND hwnd)
{
	int y1,y2,x1,y3;
	RECT Rect;
	GetWindowRect(hwnd,&Rect);
	y1 = ::GetSystemMetrics(SM_CYCAPTION);
	y2 = ::GetSystemMetrics(SM_CYMENU);
	x1 = ::GetSystemMetrics(SM_CXBORDER);
	y3 = ::GetSystemMetrics(SM_CYBORDER);
	Rect.bottom = Rect.bottom - y3 - BorderWidth;
	Rect.left = Rect.left + x1 + BorderWidth;
	Rect.right = Rect.right - x1 - BorderWidth;
	Rect.top = Rect.top + y1 + y2 + y3 + BorderWidth;
	return Rect;
}

HBITMAP DrawToBitmap(HDC hdc,POINT *point,int index,int Width,int Height)
{
	HDC hMemdc = ::CreateCompatibleDC(hdc);
	BITMAPINFO bi;
	LPBYTE lpBit = NULL;
	RECT Rect;
	long k = record_nums;
	long i = index + 1;
	long lastIndex = 1;
	Rect.left = 0;
	Rect.top = 0;
	Rect.right = Width;
	Rect.bottom = Height;
	ZeroMemory(&bi,sizeof(BITMAPINFO));
	bi.bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
	bi.bmiHeader.biWidth = Width;
	bi.bmiHeader.biHeight = Height;
	bi.bmiHeader.biPlanes = 1;
	bi.bmiHeader.biBitCount = 16;
	HBITMAP DrawBitmap = CreateDIBSection(hMemdc,(BITMAPINFO*)&bi,DIB_RGB_COLORS,(void**)&lpBit,NULL,0); 
	::SelectObject(hMemdc,DrawBitmap);
	::FillRect(hMemdc,&Rect,(HBRUSH)GetStockObject(WHITE_BRUSH));
	//drawing
	MyPoint MousePos,OldMousePos,NextMousePos,OlderMousePos;
	int xmin,xmax,ymin,ymax;
	int colorflag,NewColorFlag;
	COLORREF color;
	double distance,dnext,dold,width,view_width;
	double ZoomX = (double)Width/DrawWindowWidth;
	double ZoomY = (double)Height/DrawWindowHeight;
	double pressure;
	if(i<k-1)
	{
		while(i<k-1)
		{
			MousePos.x = point[i].x*ZoomX;
			MousePos.y = point[i].y*ZoomY;
			OldMousePos.x = point[i-1].x*ZoomX;
			OldMousePos.y = point[i-1].y*ZoomY;
			OlderMousePos.x = pt[lastIndex].x*ZoomX; 
			OlderMousePos.y = pt[lastIndex].y*ZoomY; 
			i++;
			xmin = MIN(MousePos.x,OldMousePos.x);
			xmax = MAX(MousePos.x,OldMousePos.x);
			ymin = MIN(MousePos.y,OldMousePos.y);
			ymax = MAX(MousePos.y,OldMousePos.y);

			double iToLast = Point2PointDistance(MousePos.x, MousePos.y, OlderMousePos.x, OlderMousePos.y);
			double toLine = ::GetDistanceToLine(OldMousePos.x,OldMousePos.y,OlderMousePos,MousePos);

			if(iToLast < 5 && toLine <= 1) 
			{
				//Skip the point
				continue;					
			}  

			lastIndex = i - 1;

			if(MousePos.x <= 0 || OldMousePos.x <= 0) {
				if(!(OldMousePos.x == OlderMousePos.x && OldMousePos.y == OlderMousePos.y) && MousePos.x<=0) {
					MousePos = OldMousePos;

				} else 
				{
					continue;
				}
			}

			OldMousePos = OlderMousePos;
			if(MousePos.x <=0 || OldMousePos.x <= 0) {
				continue;
			}

			width = 1.0;
			pressure = 200;
			view_width = width + 1;

			xmin = MIN(MousePos.x,OldMousePos.x);
			xmax = MAX(MousePos.x,OldMousePos.x);
			ymin = MIN(MousePos.y,OldMousePos.y);
			ymax = MAX(MousePos.y,OldMousePos.y);
			for(int p=xmin-width*2; p<=xmax+width*2; p++)
			{
				for(int q=ymin-width*2; q<=ymax+width*2; q++)
				{						
					distance = ::GetDistanceToLine(p,q,OldMousePos,MousePos);
					if(distance <= width)
					{
						colorflag = BlackColorflag;
						NewColorFlag = GetNewColorFlag(colorflag);
						color = RGB(NewColorFlag,NewColorFlag,NewColorFlag);
						SetColorAndAddToMap(hMemdc,p,q,color);
					}
					else
					{
						colorflag = (distance - width)*pressure;
						NewColorFlag = GetNewColorFlag(colorflag);
						color = RGB(NewColorFlag,NewColorFlag,NewColorFlag);
						SetColorAndAddToMap(hMemdc,p,q,color);
					}
				}
			}
		}
	}
	return DrawBitmap;
}

int GetNewColorFlag(int colorflagbydistance)
{
	int NewColorFlag = colorflagbydistance;
	if(colorflagbydistance > WhiteColorflag)
		NewColorFlag = WhiteColorflag;
	/*else if(colorflagbydistance > 150)
		NewColorFlag = WhiteColorflag;
	else 
		NewColorFlag = colorflagbydistance*150/255;*/
	/*else if(colorflagbydistance > 50 && colorflagbydistance < 100)
		NewColorFlag = 100;
	else if(colorflagbydistance>=100 && colorflagbydistance < 150)
		NewColorFlag = 100;
	else if(colorflagbydistance >= 150 && colorflagbydistance < 200)
		NewColorFlag = WhiteColorflag;
	else if(colorflagbydistance >= 200 && colorflagbydistance < WhiteColorflag)
		NewColorFlag = WhiteColorflag;*/
	return NewColorFlag;
}

void smooth(HDC hdc,int WidthOfBitmap,int HeightOfBitmap)
{
	int smoothflag,currentflag;
	for(int i=1;i<WidthOfBitmap;i++)
	{
		for(int j=1;j<HeightOfBitmap;j++)
		{
			smoothflag = ( GetRValue(GetPixel(hdc,i+1,j)) + GetRValue(GetPixel(hdc,i-1,j)) + GetRValue(GetPixel(hdc,i,j+1)) + GetRValue(GetPixel(hdc,i,j-1))
				+ GetRValue(GetPixel(hdc,i+1,j+1)) + GetRValue(GetPixel(hdc,i+1,j-1)) + GetRValue(GetPixel(hdc,i-1,j+1)) + GetRValue(GetPixel(hdc,i-1,j-1)) )/8;
			currentflag = ::GetPixel(hdc,i,j);
			if(currentflag != smoothflag)
				::SetPixel(hdc,i,j,RGB(smoothflag,smoothflag,smoothflag));
		}
	}
}