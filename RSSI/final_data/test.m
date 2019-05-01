test_data = B(16001:20403,:);
input_data = test_data(:,2:65);
%归一化处理
y2 = test_data(:,1)';
[output_data,PS] = mapminmax(y2);
input_num = 64;
%构造输出矩阵
output = output_data;
%构造输入矩阵
inputn = input_data';
inputn(input_num + 1,:)=1;
%计算样本个数
[m,n] = size(output);
L = m*n;
y=[];
for i = 1:1:L
    x = inputn(:,i);
    % 隐含层输出
    for j = 1:1:midnum
        I(j) = inputn(:,i)'*w1(j,:)';
        Iout(j) = 1/(1+exp(-I(j)));
    end
    % 输出层输出
    Iout(midnum+1) = 1;
    yn = w2'*Iout';
    y(i) = yn;
    %计算误差
    e = output(:,i) - yn; 
    E(i) = sum(abs(e));
end
y1 = mapminmax('reverse',y,PS);
E = abs(y1 - y2);
[m,n] = size(E);
x = [1:1:m*n];
average_error = mean(E)
[b1 x1]=hist(E,100);
num1=numel(E);
plot(x1,b1/num1);
c1=cumsum(b1/num1);
figure; plot(x1,c1,'-r');
figure; plot(x,y1 - y2,'-b');
