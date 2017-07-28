/*
 * Copyright 2017 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.kafka.config

import classy._
import classy.config._
import com.typesafe.config.Config

package object implicits
    extends ConsumerConfiguration
    with ProducerConfiguration
    with StreamsConfiguration {

  type ConfigValue[T] = (String, T)

  object ConfigValueDecoder {
    def apply[T](key: String)(implicit R: Read[Config, T]): ConfigDecoder[ConfigValue[T]] =
      R.read(key) map (value => (key, value))
  }

}