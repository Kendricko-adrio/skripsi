FROM node:12.18.1
WORKDIR /
ENV NODE_ENV=default

COPY ["package.json", "package-lock.json*", "./"]

RUN npm install
# RUN npm install --production

COPY . .

CMD [ "node", "index.js" ]