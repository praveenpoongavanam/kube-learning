{{- define "springboot-service.name" -}}
{{ .Chart.Name }}
{{- end }}

{{- define "springboot-service.fullname" -}}
{{ printf "%s-%s" .Release.Name .Chart.Name }}
{{- end }}
