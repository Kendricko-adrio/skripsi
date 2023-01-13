/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

const { ApolloServer, gql } = require("apollo-server");
const { ApolloGateway, IntrospectAndCompose } = require("@apollo/gateway");
require("dotenv").config();

const port = process.env.SERVER_PORT;
const usersUrl = process.env.SERVICES_USERS_URL;
const coursesUrl = process.env.SERVICES_COURSES_URL;

const gateway = new ApolloGateway({
	supergraphSdl: new IntrospectAndCompose({
		subgraphs: [
			{ name: "users", url: usersUrl },
			{ name: "courses", url: coursesUrl },
		],
	}),
});

const server = new ApolloServer({ gateway, subscriptions: false, tracing: true });
server.listen({ port: port }).then(({ url }) => {
	console.log(`🚀 Server ready at ${url}`);
});
