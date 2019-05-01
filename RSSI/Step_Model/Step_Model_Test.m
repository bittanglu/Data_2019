clear all;
clear;
%�������ݲ���
test_data = importdata('acc_data3.txt');
[w l] = size(test_data);
acc_error = test_data(:,1);
acc_average = test_data(:,2);
time = test_data(:,3);
%���߾���Ϊ36m
L = 60;
t = [];
%����
n = w;
%����ÿһ��ʱ��
for i =1:n-1
    t(i) = time(i+1) - time(i);
end
t =[t mean(t)];
%ģ�Ͳ���
% Weibergģ�ͣ�
% C = 0.4293;
% B=+0.0435;

% Kimģ�ͣ�
% C =0.1665;
% B=+0.0024;

% Scarletģ�ͣ�
C =0.2636;
B=+0.0370;

% ����ģ�ͣ�
% a = 0.0004659
% b = 0.0938
% c = 0.0484

x = [];
for i =1:n
%     Weibergģ��
%     x(i) =  nthroot(acc_error(i),4);
%     Kimģ��
%     x(i) =  acc_average(i)/acc_error(i);
%     Scarletģ��
    x(i) =  nthroot(acc_average(i),3);       
end
t =[t mean(t)];
dis = 0;
step_list = [];
for i =1:n
    step = C * x(i) + B;
    step_list =[step_list step];
    dis = dis + C * x(i) + B;
end
error = L - dis
%% ����ģ��
% x1 = t;
% x2 = acc_error;
% dis = 0;
% for i =1:n
%     dis = dis + a * x1(i) + b * x2(i) + c;
% end
% error = L - dis;